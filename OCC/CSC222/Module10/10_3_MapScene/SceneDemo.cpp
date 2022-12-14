#include "SceneDemo.h"

SceneDemo::SceneDemo()
{
}

SceneDemo::~SceneDemo()
{

}

bool SceneDemo::init()
{
    if(!initSystem("Scene Demo 3", 800, 600, false))
        return false;

    if(!map.load("graphics/map.map", "graphics/tiles.bmp"))
        return false;

    player = new MapNode(0, 10, 10, 50, 50, &map);

    scene.addNode(player);

    camera.set(0,0,800,600);

    return true;
}

void SceneDemo::update()
{
    scene.update();

    Input* in = getInput();

    if(in->keyDown(SDLK_UP))
        player->setY(player->getY()-PLAYER_SPEED);

    if(in->keyDown(SDLK_DOWN))
        player->setY(player->getY()+PLAYER_SPEED);

    if(in->keyDown(SDLK_LEFT))
        player->setX(player->getX()-PLAYER_SPEED);

    if(in->keyDown(SDLK_RIGHT))
        player->setX(player->getX()+PLAYER_SPEED);

    camera.setCenterX(player->getCenterX());
    camera.setCenterY(player->getCenterY());

    if(camera.getX() < 0)
        camera.setX(0);

    if(camera.getY() < 0)
        camera.setY(0);

    if(camera.getX2() >= map.getTotalWidth())
        camera.setX2(map.getTotalWidth() - 1);

    if(camera.getY2() >= map.getTotalHeight())
        camera.setY2(map.getTotalHeight() - 1);

    if(player->getX() < 0)
        player->setX(0);

    if(player->getY() < 0)
        player->setY(0);

    if(player->getX2() >= map.getTotalWidth())
        player->setX2(map.getTotalWidth() - 1);

    if(player->getY2() >= map.getTotalHeight())
        player->setY2(map.getTotalHeight() - 1);
}

void SceneDemo::draw(Graphics* g)
{
    map.draw(1, camera.getX(), camera.getY(), g);
    map.draw(2, camera.getX(), camera.getY(), g);
    map.draw(0, camera.getX(), camera.getY(), g);
    scene.draw(&camera, g);
}

void SceneDemo::free()
{
    scene.removeNode(NULL);

    map.free();
    freeSystem();
}
