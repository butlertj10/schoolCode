#include <string>
#include <cstring>
#include <filesystem>
#include <bits/stdc++.h>
#include <iostream>
#include <vector>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>
#include "vsh_printing_module.h"

using namespace std;
namespace fs = std::filesystem;
bool fileFound;
string filePath = "";
string userCommand, fileCommand;
string paths[4] = {"./", "/usr/local/bin/", "/usr/bin/", "/bin/"};

bool commandCatch(string tempCommand)
{
  bool temp = false;
  if ((tempCommand == "cd" || tempCommand == "pwd" || tempCommand == "exit"))
  {
    temp = true;
  }
  return temp;
}

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
const vector<string> parse()
{
  vector<string> output;
  string temp;
  string input;

  cout << "______________________________________________________________" << endl;
  cout << "\nEnter input for the terminal: ";
  getline(cin, input);
  cout << " " << endl;

  istringstream ss(input);
  while (ss >> temp)
  {
    output.push_back(temp);
  }

  return output;
}

int fork(int argc, char *argv[]) { return 0; }

/*
wait():
  If pid is equal to (pid_t)-1, status is requested for any child process. 
    In this respect, waitpid() is then equivalent to wait().

  If pid is greater than 0, it specifies the process ID of a single child process 
    for which status is requested.

  If pid is 0, status is requested for any child process whose process group ID is equal 
    to that of the calling process.

  If pid is less than (pid_t)-1, status is requested for any child process whose 
    process group ID is equal to the absolute value of pid.
*/
void myExec(const char *cmd_FullPath, const char *cmd, char **parameters)
{
  //cout << "*****************" << endl;
  pid_t pid = fork();

  if (pid == -1)
  {
    cout << "Failed to fork child" << endl;
    return;
  }
  else if (pid == 0) // 0 = child
  {
    cout << "** pid == child (0) **" << endl;
    if (execv(cmd_FullPath, parameters) < 0)
    {
      cout << "Command could not be executed" << endl;
    }
    //execv(cmd_FullPath, parameters);
    exit(0);
  }
  else // 1 = parent
  {
    cout << "** pid == parent (1) **" << endl;
    //execv(cmd_FullPath, parameters);
    wait(NULL);
    return;
  }
  //cout << "*****************" << endl;
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
 * @return bool fileFound
 */
string getPath(vector<string> tCommands)
{
  string pPath;

  //vector<const char *> cStrings;
  //const char *end_of_args = nullptr;

  //bool fileFound = false;
  fileFound = false;

  string command(tCommands.front());
  if (commandCatch(command))
  {
    pPath.append(tCommands[0]);
    pPath.append(" ");
    pPath.append(tCommands[1]);
    return pPath;
  }
  else if (command.c_str()[0] != '/' && command.c_str()[0] != '.')
  {
    cout << "Locating: " << command << endl;
    fileFound = false;
    for (int i = 0; i < 4; i++)
    {
      pPath = paths[i];
      pPath.append(command.c_str());
      //cout << "pPath --> " << pPath << endl;
      //cout << "pPath.c_str() --> " << pPath.c_str() << endl;
      //cout << "Path before check: " << fs::current_path() << endl;
      cout << "checking " << pPath.c_str() << " - ";
      if (fs::exists(pPath.c_str()))
      {
        cout << "SUCCEED";
        fileFound = true;
        if (!access(pPath.c_str(), X_OK))
        {
          cout << "; stat path - it is executable\n" << endl;
          filePath = pPath.c_str();
          fileCommand = command.c_str();
          fileFound = true;
          break;
        }
      }
      else
      {
        cout << "FAIL\n";
        fileFound = false;
      }
    }

    if (!fileFound)
    {
      cout << "vssh-a: " << tCommands.front()
           << " is an unknown command\n"
           << endl;
      ;
    }
  }

  /*cStrings.reserve(tCommands.size());

    for (size_t i = 0; i < tCommands.size(); ++i)
    {
      cStrings.push_back(tCommands[i].c_str());
    }
    cStrings.push_back(end_of_args);

    vshPrint(pPath.c_str(), tCommands.front().c_str(), cStrings.data());
  }*/

  return pPath;
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
  while (true)
  {
    vector<string> vecArgs = parse();
    string command = vecArgs[0];
    const char **cArgs = new const char *[vecArgs.size()];
    for (unsigned int i = 0; i < vecArgs.size() - 1; ++i)
    {
      cArgs[i] = vecArgs[i + 1].c_str();
    }

    cArgs[vecArgs.size() - 1] = nullptr;
    string fullPath = getPath(vecArgs);
    userCommand = vecArgs[0];

    if (userCommand == "cd")
    {
      bool tempS = false;

      cout << "cd: " << endl;
      if (vecArgs.size() == 2)
      {
        string userPath = vecArgs[1];
        for (int i = 0; i < 4; i++)
        {

          string cPath = paths[i];

          if (cPath == userPath)
          {
            tempS = true;
            fs::current_path((fs::path)(userPath));
            cout << "Directory changed to: " << fs::current_path() << endl;
            break;
          }
        }
        if (tempS == false)
        {
          cout << "ERROR: '" << userPath << "' does not exist" << endl;
          cout << "Current path remains: " << fs::current_path() << endl;
        }
      }
      else
      {
        string home = getenv("HOME");
        home.append("/");
        string fullHome = home;

        fs::current_path((fs::path)(fullHome));
        cout << "Changed to home directory: " << fs::current_path() << endl;
      }
    }
    else if (userCommand == "exit")
    {
      cout << "The Shell has been terminated" << endl;
      break;
    }
    else if (command.compare("pwd") == 0)
    {
      cout << "pwd:" << endl;
      cout << "Current path is " << fs::current_path() << endl;
    }
    else
    {
      if (vecArgs.size() == 2)
      {
        myExec(filePath.c_str(), userCommand.c_str(), (char **)fileCommand.c_str());
      }
    }

    if (fileFound == true)
    {
      vshPrint(fullPath.c_str(), command.c_str(), cArgs);
      cout << "File was found in: " << filePath << endl;
    }
    else
    {
      if (!(commandCatch(command)))
      {
        cout << "File was not found" << endl;
      }
    }

    delete[] cArgs;
  } //while
}
 /*
 ______________________________________________________________

Enter input for the terminal: ls

Locating: ls
checking ./ls - FAIL
checking /usr/local/bin/ls - FAIL
checking /usr/bin/ls - SUCCEED; stat path - it is executable

exec(/usr/bin/ls)
ls
File was found in: /usr/bin/ls
______________________________________________________________

Enter input for the terminal: ls ls

Locating: ls
checking ./ls - FAIL
checking /usr/local/bin/ls - FAIL
checking /usr/bin/ls - SUCCEED; stat path - it is executable

exec(/usr/bin/ls)
ls ls
File was found in: /usr/bin/ls
______________________________________________________________

Enter input for the terminal: cd /usr/bin

cd:
ERROR: '/usr/bin' does not exist
Current path remains: "/mnt/o/CIS310-TEMP/pVSSH-b"
exec(cd /usr/bin)
cd /usr/bin
File was found in: /usr/bin/ls
______________________________________________________________

Enter input for the terminal:
 



 **ls found in ./ after --> cd /usr/bin/** */