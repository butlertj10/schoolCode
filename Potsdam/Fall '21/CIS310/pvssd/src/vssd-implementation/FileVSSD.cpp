#include "FileVSSD.h"
#include <iostream>
#include <cstring>
#include <fstream>
#include <stdio.h>
using namespace std;

/**
* Constructor for FileVSSD with given block size, block length, and filename.
* Writes the block sizes and block count while also creating a signature. 
* Everything is then initialized to zero.
*/
FileVSSD::FileVSSD(size_t block_size, size_t block_count, string filename)
{
  fName = filename;
  blockS = block_size;
  blockC = block_count;
  fileStream.open(filename, ios::in | ios::out | ios::binary | ios::trunc);
  fileStream.write((const char *)&blockS, sizeof(blockS));
  fileStream.write((const char *)&blockC, sizeof(blockC));

  // assign signature values
  unsigned char ca = 202;
  unsigned char fe = 254;
  unsigned char ts = 117;
  unsigned char zero = 0;

  // create signature
  if (block_size > 8)
  {
    for (unsigned int i = 8; i < blockS; i++)
    {
      switch (i % 4)
      {
      case 0:
      case 2:
        fileStream.write((const char *)&ca, sizeof(ca));
        break;
      case 1:
        fileStream.write((const char *)&ts, sizeof(ts));
        break;
      case 3:
        fileStream.write((const char *)&fe, sizeof(fe));
        break;
      }
    }
  }

  // initialize everything to zero
  for (unsigned int i = 0; i < block_count; i++)
  {
    for (unsigned int j = 0; j < block_size; j++)
    {
      fileStream.write((const char *)&zero, sizeof(zero));
    }
  }

  cout << "Block Count: " << blockCount();
  cout << "\nBlock Size: " << blockSize() << "\n";
  stat = DiskStatus::OK;
}

/**
* Contructs FileVSSD with a given file name. 
* Checks if block sizes/count match those of the
* file passed in. 
*/
FileVSSD::FileVSSD(string fileName)
{
  const char *cFileName = fileName.c_str();
  FILE *fp;
  fp = fopen(cFileName, "r");
  fseek(fp, 0, SEEK_END);
  long blockLength = ftell(fp);
  long disk_size = blockS * blockC;

  fileStream.open(fileName, ios::in | ios::binary);
  fileStream.seekg(blockS, ios::beg);
  fileStream.read((std::basic_istream<char>::char_type *)&blockS, 8);

  if (blockLength != disk_size)
  {
    cout << "Block sizes/count do not match the file's block sizes/count\n";
    stat = DiskStatus::ERROR;
  }
}
FileVSSD::~FileVSSD()
{
  status();
}

/**
* Return the size (in bytes) of the blocks used by this device.
*
* @return 0 and set status if the disk is not ready; number of bytes
*         per sector otherwise.
*/
size_t FileVSSD::blockSize() const
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
size_t FileVSSD::blockCount() const
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
DiskStatus FileVSSD::status() const
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
DiskStatus FileVSSD::read(blocknumber_t sector, void *buffer)
{
  if (buffer == nullptr)
  {
    stat = DiskStatus::ERROR;
  }
  if (sector >= blockC || sector < 0)
  {
    cout << "This block is out of bounds. Enter a valid block\n" << endl;
    stat = DiskStatus::BLOCK_OUT_OF_RANGE;
  }
  else
  {
    fileStream.seekg((sector + 1) * blockS);
    fileStream.read((std::basic_istream<char>::char_type *)buffer, blockS);
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
DiskStatus FileVSSD::write(blocknumber_t sector, void *buffer)
{
  if (buffer == nullptr)
  {
    stat = DiskStatus::ERROR;
  }
  if (sector >= blockC || sector < 0)
  {
    cout << "This block is out of bounds. Enter a valid block.\n" << endl;
    stat = DiskStatus::BLOCK_OUT_OF_RANGE;
  }
  else
  {
    fileStream.seekp((sector + 1) * blockS);
    fileStream.write((std::basic_istream<char>::char_type *)buffer, blockS);
    stat = DiskStatus::OK;
  } 
  return stat;
}

/**
* Synchronize all in-memory structures out to the disk.
*
* @return returns a status code for the operation. OK if all went well.
*/
DiskStatus FileVSSD::sync()
{
  return stat;
}
