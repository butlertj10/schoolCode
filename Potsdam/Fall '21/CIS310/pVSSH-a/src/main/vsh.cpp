#include <string>
#include <cstring>
#include <filesystem>
#include <bits/stdc++.h>
#include <iostream>
#include <vector>
#include <unistd.h>
#include "vsh_printing_module.h"

using namespace std;
namespace fs = std::filesystem;

/**
 * parse(string in) takes in a string, then parses it word by word 
 * 
 * This function takes in a string to parse out by each word.
 *  It will then push each word onto a vector of strings
 *  which is then returned.
 * 
 * @param string in
 * @return vector<string> output
 */
const vector<string> parse(string in)
{
  vector<string> output;
  string temp;
  string input = in;

  istringstream ss(input);
  while (ss >> temp)
  {
    output.push_back(temp);
  }

  return output;
}

/**
 * getPath(vector<string> tCommands) checks for the proper path
 *  if no path is found, it is set to null.
 *  
 * This function takes in a vector of strings. The front of the vector
 *  (the command) is set to a string variable. It then verifies that the 
 *  command does not start with an '.' or an '/'. If it does not start 
 *  with these, it then checks for the command in each of the four 
 *  directories. When found, it then verifies that it is executable. 
 *  If no matches are found, it is labeled as 'FAIL' and set to null.
 * 
 * @param vector<string> tCommands
 * @return bool checkPath
 */
bool getPath(vector<string> tCommands)
{
  string pPath;
  vector<char *> cStrings;
  const char **args = new const char *[1];
  bool checkPath = true;

  string command(tCommands.front());
  if (command.c_str()[0] != '/' && command.c_str()[0] != '.')
  {
    checkPath = false;
    string paths[4] = {"./", "/usr/local/bin/", "/usr/bin/", "/bin/"};
    for (int i = 0; i < 4; i++)
    {
      pPath = paths[i];
      pPath.append(command.c_str());
      cout << "checking " << pPath.c_str() << " - ";
      if (filesystem::exists(pPath.c_str()))
      {
        cout << "SUCCEED";
        checkPath = true;
        if (!access(pPath.c_str(), X_OK))
        {
          cout << "; stat path - it is executable" << endl;
        }
        i = 4;
        cStrings.reserve(tCommands.size());

        for (size_t i = 1; i < tCommands.size(); ++i)
        {
          cStrings.push_back(const_cast<char *>(tCommands[i].c_str()));
        }

        if (!cStrings.empty())
        {
          vshPrint(pPath.c_str(), tCommands.front().c_str(), (const char **)&cStrings[0]);
        }
        else
        {
          vshPrint(pPath.c_str(), tCommands.front().c_str(), args);
        }
      }
      else
      {
        cout << "FAIL\n";
        pPath = "\0";
      }
    }
  }

  if (!(filesystem::exists(pPath.c_str())))
  {
    cout << "vssh-a: " << tCommands.front().c_str() << " is an unknown command.\n";
  }

  delete[] args;
  return checkPath;
}

/**
 * main program
 * 
 * main requests a users input, 'QUIT!' is the sentinal 
 *  to exit the program. If the program is not terminated
 *  by the user, it will take the input and pass it to 
 *  parse(string in). parse(input) is then set to a string
 *  vector to be passed into getPath(vector<string> tCommands).
 *  If true is returned, a file was found, if false, no file was 
 *  found. 
 * 
 * @param int argc
 * @param char *argv[]
 */
int main(int argc, char *argv[])
{
  string input;
  const string SENTINAL = "QUIT!";

  while (true)
  {
    cout << "______________________________________________________________" << endl;
    cout << "\nEnter input for the terminal (Enter 'QUIT!' to exit): ";
    getline(cin, input);
    cout << " " << endl;

    if (input == SENTINAL)
    {
      break;
    }

    vector<string> arguments = parse(input);
    if (getPath(arguments))
    {
      cout << "File was found\n";
    }
    else
    {
      cout << "File was not found\n";
    }
  }
}