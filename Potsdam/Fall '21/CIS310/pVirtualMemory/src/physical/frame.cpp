#include "frame.h"

/**
   * Get the page number associated with a non-free page.
   *
   * @return PageNumber associated with frame if frame is not free;
   * noSuchPage otherwise.
   */
PageNumber Frame::page() const
{
   return _page;
}

/**
   * Set the page number in the frame.
   *
   * @param newPage new value for the page number
   * @return PageNumber in frame after it is set
   */
PageNumber Frame::page(PageNumber newPage)
{

   _page = newPage;
   return _page;
}

/**
   * Get the reference time in a non-free frame.
   *
   * @return EventTime that the frame was last referenced if it is non-free;
   * 0 otherwise.
   *
   */
EventTime Frame::timestamp() const
{
   if (!_free)
   {
      return _reference;
   }

   return 0;
}

/**
   * Set the reference time in the frame.
   *
   * @param newReference new value for the time stamp
   * @return reference time after it is set
   */
EventTime Frame::timestamp(EventTime newReference)
{
   _reference = newReference;
   return _reference;
}

/**
   * Is the frame currently free?
   *
   * @return true if free; false otherwise
   */
bool Frame::free() const
{
   return _free;
}

/**
   * Set the free bit in the frame.
   *
   * @param newFree the new value for the free bit
   * @return free bit after it is set
   */
bool Frame::free(bool newFree)
{
   _free = newFree;
   return _free;
}

/**
 * Output operator for one PTE
 *
 * Format:
 * if free then
 *   |       free|
 * else
 *   |fffff|ttttt|
 *
 * Where fffff is the loaded page number in hex
 * Where ttttt is the decimal time stamp in space padded 5 characters
 * Note: This format does NOT include an end of line.
 *
 * @param out target output stream to print on
 * @param frame the frame to be printed
 * @return out for continued processing of the output stream
 */
std::ostream &operator<<(std::ostream &out, const Frame &frame)
{
   if (frame.free())
   {
      out << "|      free|";
   }
   else
   {
      char hexPage[20];
      sprintf(hexPage, "%x", frame.page());
      out << "|" << frame.page() << "|" << frame.timestamp() << "|";
   }
   return out;
}
