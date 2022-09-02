#ifndef FACTORY_H
#define FACTORY_H

#include "Core/Image.h"
#include "Core/Map.h"
#include "Core/SceneNode.h"

#include "Flier.h"
#include "Walker.h"

enum{ENTITY_SLUG, ENTITY_SOLDIER, ENTITY_RIDER, ENTITY_FLIER};

class Factory
{
private:
    Map* map;

    Image soldierImage;
    Image slugImage;
    Image riderImage;
    Image flierImage;
public:
    bool init(Map* m);
    void free();

    SceneNode* create(int entity, int x, int y);
};

#endif
