#include "pte.h"
#include <iomanip>

using namespace std;

/**
   * Get the FrameNumber from the PTE.
   *
   * @return the FrameNumber in the PTE if it is present;
   * noSuchFrame if the page is not present.
   */
FrameNumber PTE::frame() const
{
    return _frame;
}

/**
   * Set the FrameNumber from the PTE.
   *
   * Set the field regardless of whether or not it is present.
   *
   * @return the FrameNumber set in the PTE after it is set.
   */
FrameNumber PTE::frame(FrameNumber newFrameNumber)
{
    _frame = newFrameNumber;
    return newFrameNumber;
}

/**
   * Is the PTE present in the RAM?
   *
   * @return true if the PTE is present in the given frame.
   */
bool PTE::present() const
{
    return _present;
}

/**
   * Set the present "bit" in the PTE present in the RAM
   *
   * @param newPresent new value of present
   * @return value of present after it is set.
   */
bool PTE::present(bool newPresent)
{
    _present = newPresent;
    return newPresent;
}

/**
   * Has the page/PTE been referenced "recently"?
   *
   * @return true if PTE reference "bit" is set.
   */
bool PTE::referenced() const
{
    return _referenced;
}

/**
   * Set the referenced "bit" in the PTE
   *
   * @param newReferenced new value of referenced bit
   * @return value of represented after it is set
   */
bool PTE::referenced(bool newReferenced)
{
    _referenced = newReferenced;
    return newReferenced;
}

/**
 * Output operator for one PTE
 *
 * Format:
 * |p|r|ffffffff|
 *
 * Where p is 0/1 representing the present bit
 * Where r is 0/1 representing the referenced bit
 * Where ffffffff is the associated frame number (if present)
 * or ffffffff (noSuchPage) otherwise.
 * Note: This format does NOT include an end of line.
 *
 * @param out target output stream to print on
 * @param pte the PTE to print
 * @return out for continued processing of the output stream
 */
std::ostream &operator<<(std::ostream &out, const PTE &pte)
{
    char hexFrame[20];
    sprintf(hexFrame, "%x", pte.frame());
    out << std::hexfloat << "|" << int(pte.present()) << "|" << int(pte.referenced()) << "|" << setw(5) << setfill('0') << hexFrame << "|";
    return out;
}