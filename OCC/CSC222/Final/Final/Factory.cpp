#include "Factory.h"

bool Factory::init(Map* m)
{
    map = m;

    if(!greenSoldierImage.load("graphics/sprites/GreenSoldier.bmp", 44, 35)) // slug
        return false;

    if(!yellowSoldierImage.load("graphics/sprites/YellowSoldier.bmp", 44, 35)) //rider
        return false;

    if(!blueSoldierImage.load("graphics/sprites/BlueSoldier.bmp", 44, 35))
        return false;

    if(!redSoldierImage.load("graphics/sprites/RedSoldier.bmp", 44, 35)) // flier
        return false;

    if(!explosionImage.load("graphics/explosion.bmp", 50, 50))
        return false;

    return true;
}

void Factory::free()
{
    greenSoldierImage.free();
    yellowSoldierImage.free();
    explosionImage.free();
    blueSoldierImage.free();
    redSoldierImage.free();
}

SceneNode* Factory::create(int entity, int x, int y)
{
    switch(entity)
    {
        case ENTITY_BLUE_SOLDIER:
            return new NPC(&blueSoldierImage, this, x, y, map);
            break;

        case ENTITY_GREEN_SOLDIER:
            return new NPC(&greenSoldierImage, this, x, y, map);
            break;

        case ENTITY_YELLOW_SOLDIER:
            return new NPC(&yellowSoldierImage, this, x, y, map);
            break;

        case ENTITY_RED_SOLDIER:
            return new NPC(&redSoldierImage, this, x, y, map);
            break;

        case ENTITY_EXPLOSION:
            return new ExplosionEntity(&explosionImage, x, y);
            break;

        default:
            return new SceneNode(1, x, y, 50, 50);
    }
}
