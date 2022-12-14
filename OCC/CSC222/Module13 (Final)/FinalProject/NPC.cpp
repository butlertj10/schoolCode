#include "NPC.h"

NPC::NPC(Image* i, Factory* f, int x, int y, Map* m) : MapNode(ENTITY_ENEMY, x, y, i->getFrameWidth(), i->getFrameHeight(), true, m)
{
    sprite.setImage(i);
    yVel = 0;
    xVel = 5;
    factory = f;
    sprite.setAnimation(2, 3, 2);

    oldY = getY();

    map = m;
}

void NPC::update()
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

    std::list<SceneNode*>* nodes = getScene()->getNodes();
    for(list<SceneNode*>::iterator it = nodes->begin(); it != nodes->end(); it++)
    {
        if((*it)->getID() == ENTITY_PLAYER && overlaps(**it))
        {
            getScene()->addNode(factory->create(ENTITY_EXPLOSION, getCenterX(), getCenterY()));
            remove();
        }
    }//end for

    if(getY() > map->getTotalHeight())
    {
        remove();
    }
}

void NPC::draw(Rectangle* view, Graphics* g)
{
    sprite.draw(getX()-view->getX(), getY()-view->getY(), g);
}


