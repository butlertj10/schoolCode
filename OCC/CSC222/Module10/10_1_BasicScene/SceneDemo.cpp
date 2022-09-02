#include "SceneDemo.h"

SceneDemo::SceneDemo()
{
}

SceneDemo::~SceneDemo()
{

}

bool SceneDemo::init()
{
    if(!initSystem("Scene Demo 1", 800, 600, false))
        return false;

    if(!background.load("graphics/background.bmp"))
        return false;

    camera.set(0,0,800,600);

    return true;
}

void SceneDemo::update()
{
    scene.update();

    Input* in = getInput();

    if(in->keyDown(SDLK_UP))
        camera.setY(camera.getY()-CAM_SPEED);

    if(in->keyDown(SDLK_DOWN))
        camera.setY(camera.getY()+CAM_SPEED);

    if(in->keyDown(SDLK_LEFT))
        camera.setX(camera.getX()-CAM_SPEED);

    if(in->keyDown(SDLK_RIGHT))
        camera.setX(camera.getX()+CAM_SPEED);

    if(in->keyHit(SDLK_SPACE))
    {
        for(int i = 0; i < 10; i++)
        {
            scene.addNode(new SceneNode(0, camera.getX() + rand()%1000, camera.getY() + rand()%1000, 50, 50));
        }
    }

    if(in->keyHit(SDLK_ESCAPE))
        scene.removeNode(NULL);
}

void SceneDemo::draw(Graphics* g)
{
    background.draw(0, 0, g);
    scene.draw(&camera, g);
}

void SceneDemo::free()
{
    scene.removeNode(NULL);

    background.free();
    freeSystem();
}
