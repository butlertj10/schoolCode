#ifndef MAPDEMO_H
#define MAPDEMO_H

#include "Core/Game.h"
#include "Core/Image.h"
#include "Scene.h"
#include "Rectangle.h"

class SceneDemo : public Game
{
private:
    static const int CAM_SPEED = 10;

    Image background;
    Scene scene;
    Rectangle camera;
public:
    SceneDemo();
    ~SceneDemo();
    virtual bool init();
    virtual void update();
    virtual void draw(Graphics* g);
    virtual void free();
};

#endif
