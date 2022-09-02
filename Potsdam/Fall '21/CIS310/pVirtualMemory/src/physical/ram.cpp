#include "ram.h"
using namespace std;

/**
 * Constructor: builds a new RAM with n free Frame in it.
 *
 * @param n number of Frame in the RAM
 */
RAM::RAM(const size_t n)
{
    for (size_t i = 0; i < n; i++)
    {
        Frame nFrame;
        nFrame.free(true);
        vector<Frame>::push_back(nFrame);
    }
}

/**
 * Find the FrameNumber of a free frame, if one exists.
 *
 * @return lowest valid FrameNumber of a free Frame if one exists; noSuchFrame
 * if there are no free Frame in the RAM
 */
FrameNumber RAM::findFree()
{
    FrameNumber frameNum = noSuchFrame;

    for (size_t i = 0; i < size(); i++)
    {
        if (at(i).free())
        {
            frameNum = i;
            break;
        }
    }

    return frameNum;
}

/**
 * Find the FrameNumber of the Frame with the lowest referenced time stamp.
 *
 * @return FrameNumber of Frame where .referenced() method is the minimum
 * across RAM
 */
FrameNumber RAM::findOldest()
{
    FrameNumber max = 0;
    unsigned int maxTime = at(0).timestamp();

    for (size_t i = 1; i < size(); i++)
    {
        if (at(i).timestamp() < maxTime)
        {
            max = i;
            maxTime = at(i).timestamp();
        }
    }
    return max;
}

/**
 * Simulate loading a Frame with the contents of a given page.
 *
 * Actual content of Frame is a PageNumber (the one whose content it holds)
 * and a time stamp. This method simulates the loading of the content (and
 * the referenced time is updated elsewhere).
 *
 * Load the page to the lowest numbered free frame FrameNumber if there are any.
 * Select a FrameNumber to evict from RAM by
 * - the lowest .referenced() time of the Frame if useTimestamp is true, otherwise
 * - the FrameNumber in the lowest PageNumber that has a zero .reference() bit,
 *   if one exists, and if none exists
 * - the FrameNumber of the lowest PageNumber that is .present() in RAM.
 *
 * locateLowestPB() is used to find the lowest present bit (Located in pageTable.cpp/h)
 * 
 * @param p the PageNumber to load into RAM
 * @param pageTable the table of PTE; may be modified by loading
 * @param useTimestamp use Frame timestamps if true; use PTE referenced bits
 * if not.
 */
FrameNumber RAM::load(PageNumber p, PageTable &pageTable, bool useTimestamp)
{
    //Check for a free frame
    FrameNumber fNum = findFree();
    pageTable.at(p).present(true);

    // if free, return fNum
    if (fNum != noSuchFrame)
    {
        pageTable.at(p).frame(fNum);
        at(fNum).page(p);
        at(fNum).free(false);
        return fNum;
    }

    // UseTimeStamp if there are none free
    if (useTimestamp)
    {
        fNum = findOldest();
        pageTable.at(p).frame(fNum);
        at(fNum).page(p);
        at(fNum).free(false);
        return fNum;
    }

    // Look for lowest PageNumber with a zero reference bit if useTimestamp is false 
    PageNumber pNum = pageTable.findUnreferenced();
    if (pNum != noSuchPage)
    {
        fNum = pageTable.lookup(pNum);
        pageTable.at(p).frame(fNum);
        at(fNum).page(p);
        at(fNum).free(false);
        return fNum;
    }
    else // Else return the page's frame number with the lowest present
    {
        fNum = pageTable.lookup(pageTable.locateLowestPB());
        pageTable.at(p).frame(fNum);
        at(fNum).page(p);
        at(fNum).free(false);
        return fNum;
    }
}

/**
 * Output operator for RAM
 * Output format is
 *
 *   # Frame
 *
 * Where # is the hex page number in a space-padded field width of 3 and
 * Frame is the output
 * @param out the output stream where the RAM is to be printed
 * @param ram the memory to print
 * @return out; the output stream for continued processing
 */
std::ostream &operator<<(std::ostream &out, const RAM &ram)
{
    cout << "\n";
    for (size_t i = 0; i < ram.size(); i++)
    {
        out << "   " << hex << i << " " << ram.at(i) << "   \n"
            << endl;
    }
    return out;
}
