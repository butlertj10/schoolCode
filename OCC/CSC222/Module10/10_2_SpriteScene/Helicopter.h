#ifndef HELICOPTER_H
#define HELICOPTER_H

#include "SceneNode.h"
#include "Sprite.h"

class Helicopter : public SceneNode
{
private:
    Sprite sprite;
    int dir;

    static const int DIR_UP = 0;
    static const int DIR_DOWN = 1;
    static const int DIR_LEFT = 2;
    static const int DIR_RIGHT = 3;

    static const int ANIM_UP_START = 0;
    static const int ANIM_UP_END = 8;
    static const int ANIM_DOWN_START = 9;
    static const int ANIM_DOWN_END = 17;
    static const int ANIM_LEFT_START = 18;
    static const int ANIM_LEFT_END = 26;
    static const int ANIM_RIGHT_START = 27;
    static const int ANIM_RIGHT_END = 35;
public:
    Helicopter(Image* i, int x, int y);
    ~Helicopter();

    void update();
    void draw(Rectangle* view, Graphics* g);
    void setDir(int d);
};

#endif
