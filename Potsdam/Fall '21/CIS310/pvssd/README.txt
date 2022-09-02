The following program was tested by using the given test build and running:

#+BEGIN_SRC shell
make -j16 && ./build/vssdTEST
#+END_SRC

This allowed for easy corrections as I could see which tests were failing and could reference both TestFileVSSD.cpp and TestRAMVSSD.cpp. 

Commands are as follows:
    q
    d
    c <block-size> <block-count> [o <fname> | n <fname> | r]
    w <block> <data> [s <disk_status>]
    r <block> [x <data>] [s <disk_status>] 