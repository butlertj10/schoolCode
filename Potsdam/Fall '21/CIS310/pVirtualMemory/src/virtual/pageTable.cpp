#include "pageTable.h"
using namespace std;

/**
   * Constructor takes the number of pages in the page table.
   */
PageTable::PageTable(const size_t n)
{
    for (size_t i = 0; i < n; i++)
    {
        PTE pte;
        push_back(pte);
    }
}

/**
   * Clear the referenced bit in all PTE.
   */
void PageTable::clearReferenced()
{
    for (size_t i = 0; i < size(); i++)
    {
        at(i).referenced(false);
    }

    return;
}

/**
   * Lookup the given page in the PageTable.
   *
   * @param p page number to translate to FrameNumber
   * @return the FrameNumber where the page is loaded (if it is present)
   * noSuchFrame otherwise
   */
FrameNumber PageTable::lookup(PageNumber p)
{
    FrameNumber frameNum = noSuchFrame;

    for (size_t i = 0; i < size(); i++)
    {
        if (findByFrame(at(i).frame()) == p)
        {
            frameNum = at(i).frame();
            break;
        }
    }

    return frameNum;
}

/**
   * Find the lowest page number that is unreferenced.
   *
   * @return valid page number of an unreferenced, present page
   * if there is one; noSuchPage otherwise.
   */
PageNumber PageTable::findUnreferenced()
{
    FrameNumber pageNum = noSuchFrame;

    for (size_t i = 0; i < size(); i++)
    {
        if (!at(i).referenced() && at(i).present())
        {
            pageNum = i;
            break;
        }
    }

    return pageNum;
}

/**
   * Find the page number associated with the give frame.
   *
   * @return page number of present page referring to given frame;
   * noSuchPage if there is no such page.
   */
PageNumber PageTable::findByFrame(FrameNumber frame)
{
    FrameNumber pageNum = noSuchFrame;

    for (size_t i = 0; i < size(); i++)
    {
        if (at(i).frame() == frame)
        {
            pageNum = i;
            break;
        }
    }

    return pageNum;
}

/**
   * Finds the lowest present bit
   *
   * @return the lowest present bit located;
   * noSuchPage if one is not found.
   */
PageNumber PageTable::locateLowestPB()
{
    for (size_t i = 0; i < size(); i++)
    {
        if (at(i).present())
        {
            return i;
        }
    }

    return noSuchPage;
}

/**
 * Output operator for PageTable
 * Output format is
 *
 *   # PTE
 *
 * Where # is the hex page number in a space-padded field width of 3.
 * @param out the output stream where the page table is to be printed
 * @param pageTable the page table to print
 * @return out; the output stream for continued processing
 */
std::ostream &operator<<(std::ostream &out, const PageTable &pageTable)
{
    cout << "\n";
    for (size_t i = 0; i < pageTable.size(); i++)
    {

        out << "   " << hex << i << " " << pageTable.at(i) << "   \n"
            << endl;
    }
    return out;
}
