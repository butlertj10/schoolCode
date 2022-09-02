#include "Helicopter.h"

Sprite sprite;

Helicopter::Helicopter(Image* i, int x, int y) : SceneNode(0, x, y, i->getFrameWidth(), i->getFrameHeight())
{
    sprite.setImage(i);
    dir = -1;

    setDir(rand()%4);
}

Helicopter::~Helicopter()
{

}

void Helicopter::update()
{
    sprite.update();
}

void Helicopter::draw(Rectangle* view, Graphics* g)
{
    sprite.draw(getX() - view->getX(), getY() - view->getY(), g);
}

void Helicopter::setDir(int d)
{
    if(dir != d)
    {
        dir = d;

        if(dir == DIR_UP)
            sprite.setAnimation(ANIM_UP_START, ANIM_UP_END, 0);

        if(dir == DIR_DOWN)
            sprite.setAnimation(ANIM_DOWN_START, ANIM_DOWN_END, 0);

        if(dir == DIR_LEFT)
            sprite.setAnimation(ANIM_LEFT_START, ANIM_LEFT_END, 0);

        if(dir == DIR_RIGHT)
            sprite.setAnimation(ANIM_RIGHT_START, ANIM_RIGHT_END, 0);
    }
}
