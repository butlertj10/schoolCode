#include "virtualMemoryTypes.h"

PageNumber getPage(VirtualAddress va)
{
    PageNumber pageNum = pageMask & va;
    pageNum = pageNum >> offsetWidth;
    return pageNum;
}

Offset getOffset(VirtualAddress va)
{
    return offsetMask & va;
}