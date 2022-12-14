#include <vector>
#include <string>
#include <filesystem>
#include <algorithm> 


/**
 * vshPrint - Pretty-print the parameters that would be used to exec a command
 * in a shell.
 *
 * @param cmd_FullPath - the full path name of the command that will be executed
 * @param cmd - original first word in the command line entered
 * @param parameters - a null-terminated array of character pointers
 * pointing at the rest of the words of the commandline
 */
void vshPrint(const char *cmd_FullPath, const char *cmd,
              const char **parameters);


