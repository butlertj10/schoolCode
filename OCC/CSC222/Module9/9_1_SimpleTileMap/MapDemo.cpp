#include "MapDemo.h"

MapDemo::MapDemo()
{

}

MapDemo::~MapDemo()
{

}

bool MapDemo::init()
{
    if(!initSystem("Map Demo 1", 800, 600, false))
        return false;

    if(!map.init("graphics/tiles.bmp"))
        return false;

    if(!background.load("graphics/background.bmp"))
        return false;

    return true;
}

void MapDemo::update()
{

}

void MapDemo::draw(Graphics* g)
{
    background.draw(0, 0, g);
    map.draw(g);
}

void MapDemo::free()
{
    map.free();
    background.free();
    freeSystem();
}
