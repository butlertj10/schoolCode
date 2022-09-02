#include "RAMVSSD.h"
#include <memory>
#include <iostream>
using namespace std;

/** 
* Constructor for RAMVSSD which passes both block size and block count.
* Find the total disk size then initializes everything to zero. 
* Then creates a dynamic array with unique pointer.
*/
RAMVSSD::RAMVSSD(size_t block_size, size_t block_count)
{
  blockC = block_count;
  blockS = block_size;
  diskSize = block_size * block_count;

  for (unsigned int i = 0; i < blockC; i++)
  {
    memory = {0};
  }

  memory = make_unique<char[]>(diskSize);
  stat = DiskStatus::OK;
}

/** 
* Deconstructor to reset the memory
*/
RAMVSSD::~RAMVSSD()
{
  memory.reset();
}

/**
* Return the size (in bytes) of the blocks used by this device.
*
* @return 0 and set status if the disk is not ready; number of bytes
*         per sector otherwise.
*/
size_t RAMVSSD::blockSize() const
{
  if (stat == DiskStatus::ERROR)
  {
    return 0;
  }
  else
  {
    return blockS;
  }
}

/**
* Return the total number of blocks on the disk.
*
* @return 0 and set status if the disk is not ready; number of
*         sectors otherwise.
*/
size_t RAMVSSD::blockCount() const
{
  if (stat == DiskStatus::ERROR)
  {
    return 0;
  }
  else
  {
    return blockC;
  }
}

/**
* Return the status of the disk (typically the last call).
*/
DiskStatus RAMVSSD::status() const
{
  return stat;
}

/**
* Read indicated block if possible.
*
* Read the sector of data indicated by the sector number into the
* provided buffer.
*
* @param sector the index of the sector to read; must check for valid range
* @param buffer pointer to memory where data is to be stored; must be
*        checked for null
* @return OK if all is well, appropriate error code otherwise.
*/
DiskStatus RAMVSSD::read(blocknumber_t sector, void *buffer)
{
  if (buffer == nullptr)
  {
    stat = DiskStatus::ERROR;
  }
  else if (sector >= blockC || sector < 0)
  {
    cout << "This block is out of bounds.\n";
    stat = DiskStatus::BLOCK_OUT_OF_RANGE;
  }
  else
  {
    void *start = memory.get() + (sector * blockS);
    memcpy(buffer, start, blockS);
    stat = DiskStatus::OK;
  }

  return stat;
}

/**
* Write indicated block if possible.
*
* Write the given buffer of data to the sector with the given sector number.
*
* @param sector the index of the sector to write; must check for valid range
* @param buffer pointer to memory where data is to be stored; must be
*        checked for null
* @return OK if all is well, appropriate error code otherwise.
*/
DiskStatus RAMVSSD::write(blocknumber_t sector, void *buffer)
{
  if (buffer == nullptr)
  {
    stat = DiskStatus::ERROR;
  }
  if (sector >= blockC || sector < 0)
  {
    cout << "This block is of bounds. Enter a valid block.\n";
    stat = DiskStatus::BLOCK_OUT_OF_RANGE;
  }
  else
  {
    void *start = memory.get() + (sector * blockS);
    memcpy(start, buffer, blockS);
    stat = DiskStatus::OK;
  }

  return stat;
}

/**
* Synchronize all in-memory structures out to the disk.
*
* @return returns a status code for the operation. OK if all went well.
*/
DiskStatus RAMVSSD::sync()
{
  return stat;
}
