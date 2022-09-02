*********************************************************************************
* Author: Trevor Butler                                                         *
* Course: CIS310 - Dr. Ladd                                                     *               
* Email: butlertj203@potsdam.edu                                                *
* Problem: Implementing a fair concurrency operator, a TicketLock. This program *
*   should act as a deli market we discussed. A process will get a ticket       *
*   number to be "served". There will be the creation of threads to handle      *
*   each process and keep track of their turn using the TicketLock class.       *
*   The process will be locked so ensure it completes then unlocked once        *
*   finished. Each worker thread display infomation regarding which thread the  *
*   process is on, which ticket is being processed, and which turn it is        *
*   (using modulo).                                                             *
*********************************************************************************

Testing:
    To test this assignment, the given program was ran as output was documented. 
        I then took this output and compared it to the results of the completed
        program. Here I could see that the code was running properly as the turns
        were printing values, as well as threads completing after certain worker
        threads were complete. 
    I also changed the value in ticketLockTest.cpp where threadNumber is checked 
        to equal zero. I changed this to 10 to verify that everything is in order
        as it should be, omitting thread zero's four seconds of work after it runs
        the lock.
    Further, after every execution of the program, the final value was equal to 
        itself. This shows that program ran and incremented as it should. 

Shell:
    To run this program, 'make -j16 && ./build/ticketLockTest' was entered into the 
        shell (-j16 for my 16 core processor; -jX where X is the number of CPU cores
        your machine has). 
    This gave me the output:

    #+BEGIN_SRC bash
        butlertj10@Trevor-PC:/mnt/o/CIS310-TEMP/pticketlock$ make -j16 && ./build/ticketLockTest
        src/locks/
        src/os_dependent/
        src/main/
        g++ -I include -I src/locks/ -I src/os_dependent/ -I src/main/ -pthread -std=c++2a -O0 -Wall -Werror -g -c src/main/ticketLockTest.cpp -o build/main/ticketLockTest.o
        g++ -pthread -std=c++2a -O0 -Wall -Werror -g -o build/ticketLockTest build/locks/ticketLock.o build/main/ticketLockTest.o -lstdc++fs
        ./build/ticketLockTest starts with (10, 3)
        main: joining worker_thread 0
        worker_thread 0[0]: counter (ticket/turn): 0(1/1)
        worker_thread 1[0]: counter (ticket/turn): 1(2/1)
        worker_thread 2[0]: counter (ticket/turn): 2(0/2)
        worker_thread 1[1]: counter (ticket/turn): 3(1/1)
        worker_thread 2[1]: counter (ticket/turn): 4(2/1)
        worker_thread 1[2]: counter (ticket/turn): 5(0/0)
        worker_thread 2[2]: counter (ticket/turn): 6(1/0)
        worker_thread 1[3]: counter (ticket/turn): 7(2/2)
        worker_thread 2[3]: counter (ticket/turn): 8(0/0)
        worker_thread 1[4]: counter (ticket/turn): 9(1/1)
        worker_thread 2[4]: counter (ticket/turn): 10(2/1)
        worker_thread 1[5]: counter (ticket/turn): 11(0/0)
        worker_thread 2[5]: counter (ticket/turn): 12(1/0)
        worker_thread 1[6]: counter (ticket/turn): 13(2/2)
        worker_thread 2[6]: counter (ticket/turn): 14(0/0)
        worker_thread 1[7]: counter (ticket/turn): 15(1/1)
        worker_thread 2[7]: counter (ticket/turn): 16(2/1)
        worker_thread 1[8]: counter (ticket/turn): 17(0/0)
        worker_thread 2[8]: counter (ticket/turn): 18(1/1)
        worker_thread 1[9]: counter (ticket/turn): 19(2/2)
        worker_thread 2[9]: counter (ticket/turn): 20(0/0)
        worker_thread 1: done
        worker_thread 2: done
        worker_thread 0[1]: counter (ticket/turn): 21(1/1)
        worker_thread 0[2]: counter (ticket/turn): 22(2/2)
        worker_thread 0[3]: counter (ticket/turn): 23(0/0)
        worker_thread 0[4]: counter (ticket/turn): 24(1/1)
        worker_thread 0[5]: counter (ticket/turn): 25(2/2)
        worker_thread 0[6]: counter (ticket/turn): 26(0/0)
        worker_thread 0[7]: counter (ticket/turn): 27(1/1)
        worker_thread 0[8]: counter (ticket/turn): 28(2/2)
        worker_thread 0[9]: counter (ticket/turn): 29(0/0)
        worker_thread 0: done
        main: joined worker_thread 0
        main: joining worker_thread 1
        main: joined worker_thread 1
        main: joining worker_thread 2
        main: joined worker_thread 2
        ./build/ticketLockTest ends with (10, 3)
        Final value: 30 = 30
        butlertj10@Trevor-PC:/mnt/o/CIS310-TEMP/pticketlock$
    #+END_SRC