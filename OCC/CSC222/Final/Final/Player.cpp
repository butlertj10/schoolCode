#include "Player.h"

Player::Player(int i, int x, int y, int width, int height, bool s, Map* m, Image* pImage) : SceneNode(i, x, y, width, height)
{
    map = m;
    solid = s;
    sprite.setImage(pImage);
}
Player::Player(Image* pImage, Map* m, int x, int y, int width, int height, bool s, Factory* f) : SceneNode(ENTITY_PLAYER, x, y, width, height)
{
    map = m;
    solid = s;
    sprite.setImage(pImage);
    factory = f;
}
Player::~Player()
{

}

void Player::update()
{
    sprite.setAnimation(0, 2, 0); //010
    sprite.update();
}

bool Player::overlapsMap()
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

void Player::move(int x, int y)
{
    if(!solid || map == NULL)
    {
        setX(getX() + x);
        setY(getY() + y);
        return;
    }

    setX(getX() + x);

    if(x < 0)
    {
        if(overlapsMap())
        {
            setX(((getX()/map->getTileWidth()) + 1) * map->getTileWidth());
        }
    }

    if(x > 0)
    {
        if(overlapsMap())
        {
            setX2((getX2()/map->getTileWidth()) * map->getTileWidth() - 1);
        }
    }

    setY(getY() + y);

    if(y < 0)
    {
        if(overlapsMap())
        {
            setY(((getY()/map->getTileHeight()) + 1) * map->getTileHeight());
        }
    }

    if(y > 0)
    {
        if(overlapsMap())
        {
            setY2((getY2()/map->getTileHeight())* map->getTileHeight() - 1);
        }
    }
}



void Player::draw(Rectangle* view, Graphics* g)
{
    sprite.draw(getX() - view->getX(), getY() - view->getY(), g);
}
