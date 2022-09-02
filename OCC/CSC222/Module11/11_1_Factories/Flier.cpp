#include "Flier.h"

Flier::Flier(Image* i, int x, int y, Map* m) : MapNode(1, x, y, i->getFrameWidth(), i->getFrameHeight(), false, m)
{
    sprite.setImage(i);
    xVel = 5;
    sprite.setAnimation(2, 3, 1);

    map = m;
}

void Flier::update()
{
    if(getX2() >= map->getTotalWidth())
    {
        xVel*=-1;
        sprite.setAnimation(0, 1, 2);
    }

    if(getX() <= 0)
    {
        xVel*=-1;
        sprite.setAnimation(2, 3, 2);
    }

    move(xVel, 0);
    sprite.update();
}

void Flier::draw(Rectangle* view, Graphics* g)
{
    sprite.draw(getX()-view->getX(), getY()-view->getY(), g);
}

