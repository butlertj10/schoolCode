#include "SceneDemo.h"

SceneDemo::SceneDemo()
{
}

SceneDemo::~SceneDemo()
{

}

bool SceneDemo::init()
{
    if(!initSystem("Scene Demo 2", 800, 600, false))
        return false;

    if(!helicopterImage.load("graphics/helicopter.bmp", 110, 110))
        return false;

    camera.set(0,0,800,600);

    for(int i = 0; i < 100; i++)
    {
        scene.addNode(new Helicopter(&helicopterImage,
                                     camera.getX() + rand()%2000,
                                     camera.getY() + rand()%2000));
    }

    return true;
}

void SceneDemo::update()
{
    scene.update();

    Input* in = getInput();

    if(in->keyDown(SDLK_DOWN))
        camera.setY(camera.getY()-CAM_SPEED);

    if(in->keyDown(SDLK_UP))
        camera.setY(camera.getY()+CAM_SPEED);

    if(in->keyDown(SDLK_RIGHT))
        camera.setX(camera.getX()-CAM_SPEED);

    if(in->keyDown(SDLK_LEFT))
        camera.setX(camera.getX()+CAM_SPEED);
}

void SceneDemo::draw(Graphics* g)
{
    g->clear(255, 255, 255);
    scene.draw(&camera, g);
}

void SceneDemo::free()
{
    scene.removeNode(NULL);

    helicopterImage.free();
}
