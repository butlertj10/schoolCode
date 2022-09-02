#ifndef FLIER_H
#define FLIER_H

#include "Core/MapNode.h"
#include "Core/Sprite.h"

class Flier : public MapNode
{
private:
    int xVel;
    Map* map;
    Sprite sprite;
public:
    Flier(Image* i, int x, int y, Map* m);
    ~Flier(){};

    void update();
    void draw(Rectangle* view, Graphics* g);
};

#endif
