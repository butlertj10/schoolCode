#include "ScriptDemo.h"

bool ScriptDemo::init()
{
    if(!initSystem("Script", 800, 600, false))
        return false;

    if(!map.load("graphics/platformer.map", "graphics/tiles.bmp"))
        return false;

    if(!cursorImage.load("graphics/cursor.bmp"))
        return false;

    if(!factory.init(&map))
        return false;

    if(!load())
        return false;

    camera.setSize(800, 600);
    camera.setX(0);
    camera.setY2(map.getTotalHeight()-1);

    getInput()->hideCursor(true);

    return true;
}

void ScriptDemo::free()
{
    scene.removeNode(NULL);
    cursorImage.free();
    map.free();
    factory.free();
    freeSystem();
}

void ScriptDemo::update()
{
    Input* in = getInput();

    if(in->keyDown(SDLK_LEFT))
    {
        camera.setX(camera.getX() - CAM_SPEED);
    }

    if(in->keyDown(SDLK_RIGHT))
    {
        camera.setX(camera.getX() + CAM_SPEED);
    }

    if(camera.getX() < 0)
        camera.setX(0);

    if(camera.getX2() >= map.getTotalWidth())
    {
        camera.setX2(map.getTotalWidth()-1);
    }

    scene.update();
}

void ScriptDemo::draw(Graphics* g)
{
    g->clear(0, 255, 255);

    for(int i = 1; i < 4; i++)
    {
        map.draw(i, camera.getX(), camera.getY(), g);
    }

    scene.draw(&camera, g);

    int cursorX = getInput()->getMouseX() - cursorImage.getWidth()/2;
    int cursorY = getInput()->getMouseY() - cursorImage.getHeight()/2;
    cursorImage.draw(cursorX, cursorY, g);
}

bool ScriptDemo::load()
{
    ifstream in("script.txt");

    if(!in.good())
    {
        return false;
    }

    while(!in.eof())
    {
        parseLine(&in);
    }

    in.close();

    return true;
}

void ScriptDemo::parseLine(ifstream* in)
{
    char command[64];
    (*in)>>command;

    if(!strcmp(command, "soldier"))
    {
        int x;
        int y;

        (*in)>>x;
        (*in)>>y;

        scene.addNode(factory.create(ENTITY_SOLDIER, x, y));
    }

    if(!strcmp(command, "slug"))
    {
        int x;
        int y;

        (*in)>>x;
        (*in)>>y;

        scene.addNode(factory.create(ENTITY_SLUG, x, y));
    }

    if(!strcmp(command, "rider"))
    {
        int x;
        int y;

        (*in)>>x;
        (*in)>>y;

        scene.addNode(factory.create(ENTITY_RIDER, x, y));
    }

    if(!strcmp(command, "flier"))
    {
        int x;
        int y;

        (*in)>>x;
        (*in)>>y;

        scene.addNode(factory.create(ENTITY_FLIER, x, y));
    }
}
