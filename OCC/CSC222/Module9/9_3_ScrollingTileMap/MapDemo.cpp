#include "MapDemo.h"

MapDemo::MapDemo()
{
    mapX = mapY = 0;
}

MapDemo::~MapDemo()
{

}

bool MapDemo::init()
{
    if(!initSystem("Map Demo 3", 800, 600, false))
        return false;

    if(!map.load("graphics/platformer.map", "graphics/tiles.bmp"))
        return false;

    if(!background.load("graphics/background.bmp"))
        return false;

    return true;
}

void MapDemo::update()
{
    Input* in = getInput();

   // if(in->keyDown(SDLK_UP))
     //   mapY -= SCROLL_SPEED;

    if(in->keyDown(SDLK_DOWN))
        mapY += SCROLL_SPEED;

    if(in->keyDown(SDLK_LEFT))
        mapX -= SCROLL_SPEED;

    if(in->keyDown(SDLK_RIGHT))
        mapX += SCROLL_SPEED;
}

void MapDemo::draw(Graphics* g)
{
    background.draw(0,0, g);
    map.draw(mapX, mapY, g);
}

void MapDemo::free()
{
    map.free();
    background.free();
    freeSystem();
}
