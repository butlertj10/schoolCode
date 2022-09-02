#ifndef WALKER_H
#define WALKER_H

#include "Core/MapNode.h"
#include "Core/Sprite.h"

class Walker : public MapNode
{
private:
    int yVel;
    int xVel;
    int oldY;
    Map* map;
    Sprite sprite;
public:
    Walker(Image* i, int x, int y, Map* m);
    ~Walker(){};

    void update();
    void draw(Rectangle* view, Graphics* g);
};

#endif
