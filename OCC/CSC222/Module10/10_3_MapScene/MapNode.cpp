#include "MapNode.h"

MapNode::MapNode(int i, int x, int y, int width, int height, Map* m) : SceneNode(i, x, y, width, height)
{
    map = m;
}

MapNode::~MapNode()
{

}

void MapNode::draw(Rectangle* view, Graphics* g)
{
    if(overlapsMap())
    {
        g->fillRect(getX() - view->getX(), getY() - view->getY(),
                getWidth(), getHeight(), 255, 0, 0);
    }
    else
    {
        g->fillRect(getX() - view->getX(), getY() - view->getY(),
                getWidth(), getHeight(), 0, 0, 255);

    }
}

bool MapNode::overlapsMap()
{
    if(map == NULL)
        return false;

    for(int x = getX(); x < getX2(); x+= map->getTileWidth())
    {
        for(int y = getY(); y < getY2(); y+= map->getTileHeight())
        {
            if(map->checkSolid(x/map->getTileWidth(), y/map->getTileHeight()))
            {
                return true;
            }
        }

        if(map->checkSolid(x/map->getTileWidth(), getY2()/map->getTileHeight()))
        {
            return true;
        }
    }

    for(int y = getY(); y < getY2(); y+= map->getTileHeight())
    {
        if(map->checkSolid(getX2()/map->getTileWidth(), y/map->getTileHeight()))
        {
            return true;
        }
    }

    return map->checkSolid(getX2()/map->getTileWidth(), getY2()/map->getTileHeight());
}

