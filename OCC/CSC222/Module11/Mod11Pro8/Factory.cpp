#include "Factory.h"

bool Factory::init(Map* m)
{
    map = m;

    //if(!playerImage.load("graphics/playerImage.bmp", 22, 20))
       // return false;

    if(!slugImage.load("graphics/slug.bmp", 30, 20))
        return false;

    if(!riderImage.load("graphics/rider.bmp", 49, 40))
        return false;

    if(!explosionImage.load("graphics/explosion.bmp", 50, 50))
        return false;

    return true;
}

void Factory::free()
{
    playerImage.free();
    slugImage.free();
    riderImage.free();
    explosionImage.free();
}

SceneNode* Factory::create(int entity, int x, int y)
{
    switch(entity)
    {
        case ENTITY_SLUG:
            return new NPC(&slugImage, this, x, y, map);
            break;

        case ENTITY_RIDER:
            return new NPC(&riderImage, this, x, y, map);
            break;

        case ENTITY_EXPLOSION:
            return new ExplosionEntity(&explosionImage, x, y);
            break;

        default:
            return new SceneNode(1, x, y, 50, 50);
    }
}
