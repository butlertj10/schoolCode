#include "Walker.h"

Walker::Walker(Image* i, int x, int y, Map* m) : MapNode(1, x, y, i->getFrameWidth(), i->getFrameHeight(), true, m)
{
    sprite.setImage(i);
    yVel = 0;
    xVel = 5;
    sprite.setAnimation(2, 3, 2);

    oldY = getY();

    map = m;
}

void Walker::update()
{
    if(getY() == oldY) //Not falling
    {
        yVel = 1;
        sprite.update();

        if(xVel > 0) //Moving Right
        {
            bool edge = !map->checkSolid((getX2()+1)/map->getTileWidth(), (getY2()+1)/map->getTileHeight());
            bool wall = map->checkSolid((getX2()+1)/map->getTileWidth(), (getY())/map->getTileHeight());
            if(edge || wall)
            {
                xVel*=-1;
                sprite.setAnimation(0, 1, 2);
            }
        }

        if(xVel < 0)
        {
            bool edge = !map->checkSolid((getX()-1)/map->getTileWidth(), (getY2()+1)/map->getTileHeight());
            bool wall = map->checkSolid((getX()-1)/map->getTileWidth(), (getY())/map->getTileHeight());

            if(edge || wall)
            {
                xVel*=-1;
                sprite.setAnimation(2, 3, 2);
            }
        }

        oldY = getY();
        move(xVel, yVel);
    }
    else
    {
        yVel++;

        oldY = getY();
        move(0, yVel);
    }

    if(getY() > map->getTotalHeight())
    {
        remove();
    }
}

void Walker::draw(Rectangle* view, Graphics* g)
{
    sprite.draw(getX()-view->getX(), getY()-view->getY(), g);
}
