#include "Factory.h"

bool Factory::init(Map* m)
{
    map = m;

    if(!soldierImage.load("graphics/sprites/soldier.bmp", 23, 20))
        return false;

    if(!slugImage.load("graphics/sprites/slug.bmp", 33, 20))
        return false;

    if(!riderImage.load("graphics/sprites/rider.bmp", 50, 40))
        return false;

    if(!flierImage.load("graphics/sprites/flier.bmp", 62, 35))
        return false;

    return true;
}

void Factory::free()
{
    soldierImage.free();
    slugImage.free();
    riderImage.free();
    flierImage.free();
}

SceneNode* Factory::create(int entity, int x, int y)
{
    switch(entity)
    {
        case ENTITY_SOLDIER:
            return new Walker(&soldierImage, x, y, map);
            break;

        case ENTITY_SLUG:
            return new Walker(&slugImage, x, y, map);
            break;

        case ENTITY_RIDER:
            return new Walker(&riderImage, x, y, map);
            break;

        case ENTITY_FLIER:
            return new Flier(&flierImage, x, y, map);
            break;

        default:
            return new SceneNode(1, x, y, 50, 50);
    }
}
