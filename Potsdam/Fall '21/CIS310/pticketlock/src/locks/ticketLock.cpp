#include "ticketLock.h"
#include <SpinLock.h>
#include <thread>
#include <chrono>

TicketLock::TicketLock(unsigned int turnCount)
{
  // set each TicketLock variable
  turn = 0;
  currentProcess = 1;
  totalTurns = turnCount;
  spinLock = new SpinLock();
}

TicketLock::Ticket TicketLock::lock() volatile
{
  // Lock to make sure process is complete, create a ticket to return, unlock when finished
  spinLock->lock();
  TicketLock::Ticket *ticket = new TicketLock::Ticket(TicketLock::evil_increment(turn) % totalTurns, currentProcess % totalTurns);
  spinLock->unlock();

  while (ticket->ticket != currentProcess % totalTurns){
    //wait
  }

  return *ticket;
}

void TicketLock::unlock() volatile
{
  // This will unlock the lock by incrementing the current process
  TicketLock::evil_increment(currentProcess);
}

// slowly increment the given variable; increment and delay are both defaulted
unsigned int TicketLock::evil_increment(volatile unsigned int &toBeIncremented, int incrementToAdd, unsigned int millisecondsToHold) volatile
{
  unsigned int initialValue = toBeIncremented;
  std::this_thread::sleep_for(std::chrono::milliseconds(millisecondsToHold));
  toBeIncremented = initialValue + incrementToAdd;
  return toBeIncremented;
}
