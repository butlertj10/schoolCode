*********************************************************************************
* Author: Trevor Butler                                                         *
* Course: CIS310 - Dr. Ladd                                                     *                                        
* Email: butlertj203@potsdam.edu                                                *
* Problem: Create a program that reads a virtual address trace and translates   *
*           it to a physical address trace. The virtual and physical memory     *
            spaces are hardwired where they can easily be changed after RAM     *
            and pageTable are properly set up.                                  *
*********************************************************************************

All functions were implemented for their corresponding .h files. This allows for    
    a virtual address trace to translate into a physical address trace.

TESTING:
    To test this program, 'make -j16 && ./build/vmSimulator < tests/trace00.txt'
        was entered into the shell to see what my program's output was. From 
        there, these results were compared to the output of benchmark.
    
    This allowed me to see if there were any errors compared to the proper    
        implementation and where the errors were.