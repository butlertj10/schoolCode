#include "Factory.h"

bool Factory::init(Map* m)
{
    map = m;

    if(!slugImage.load("graphics/slug.bmp", 30, 20))
        return false;

    if(!riderImage.load("graphics/rider.bmp", 49, 40))
        return false;

    if(!soldierImage.load("graphics/soldier.bmp", 22, 20))
        return false;

    if(!flierImage.load("graphics/flier.bmp", 32, 32))
        return false;

    if(!explosionImage.load("graphics/explosion.bmp", 50, 50))
        return false;

    return true;
}

void Factory::free()
{
    slugImage.free();
    riderImage.free();
    explosionImage.free();
    soldierImage.free();
    flierImage.free();
}

SceneNode* Factory::create(int entity, int x, int y)
{
    switch(entity)
    {
        case ENTITY_SOLDIER:
            return new NPC(&soldierImage, this, x, y, map);
            break;

        case ENTITY_SLUG:
            return new NPC(&slugImage, this, x, y, map);
            break;

        case ENTITY_RIDER:
            return new NPC(&riderImage, this, x, y, map);
            break;

        case ENTITY_FLIER:
            return new NPC(&flierImage, this, x, y, map);
            break;

        case ENTITY_EXPLOSION:
            return new ExplosionEntity(&explosionImage, x, y);
            break;

        default:
            return new SceneNode(1, x, y, 50, 50);
    }
}
