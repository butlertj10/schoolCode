#ifndef MAPNODE_H
#define MAPNODE_H

#include "Map.h"
#include "SceneNode.h"

class MapNode : public SceneNode
{
private:
    Map* map;
public:
    MapNode(int i, int x, int y, int width, int height, Map* m);
    ~MapNode();

    virtual void draw(Rectangle* view, Graphics* g);

    bool overlapsMap();
};

#endif
