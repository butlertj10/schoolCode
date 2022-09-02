This code was tested by going to my terminal and navigating my own ., /usr/local/bin, /usr/bin, /bin directories.
In a separate terminal tab, I ran my program with these results:

#+BEGIN_SRC vssh-a
butlertj10@Trevor-PC:/mnt/o/CIS310/pVSSH-a$ make -j16 && ./build/vsh
src/util/
src/main/
g++ -I include -I src/util/ -I src/main/ -MMD -MP -std=c++2a -O0 -Wall -Werror -g -c src/main/vsh.cpp -o build/main/vsh.o
g++ -std=c++2a -O0 -Wall -Werror -g -o build/vsh build/util/vsh_printing_module.o build/main/vsh.o -lstdc++fs
______________________________________________________________

Enter input for the terminal (Enter 'QUIT!' to exit): ls abc

checking ./ls - FAIL
checking /usr/local/bin/ls - FAIL
checking /usr/bin/ls - SUCCEED; stat path - it is executable
exec(/usr/bin/ls)
ls abc
File was found
______________________________________________________________

Enter input for the terminal (Enter 'QUIT!' to exit): al abc

checking ./al - FAIL
checking /usr/local/bin/al - FAIL
checking /usr/bin/al - FAIL
checking /bin/al - FAIL
vssh-a: al is an unknown command.
File was not found
______________________________________________________________

Enter input for the terminal (Enter 'QUIT!' to exit): QUIT!

butlertj10@Trevor-PC:/mnt/o/CIS310/pVSSH-a$
#+END_SRC

In the first section, 'ls abc' was entered where it was then located in /usr/bin. I then went to my other terminal tab
    and naviagted to my /usr/bin directory. Once in that directory I entered 'ls -l' to show all the contents of the 
    directory. I scrolled up until I found 'ls' which then verified that 'ls' was in fact located in the /usr/bin directory.

In the second section, 'al abc' was entered. I followed the same idea as previously stated execpt this time I checked 
    each directory given (., /usr/local/bin, /usr/bin, /bin) for 'al'. This command did not appear in any of these directories
    thus vaildating that when a command is not present, it will result in 'FAIL' and an unknown command statement.

In the last section, 'QUIT!' was entered, which is the sentinal to end the program. Once entered and return was hit, the 
    program terminated bringing me back to my terminal.