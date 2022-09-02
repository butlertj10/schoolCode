#include "FactoryDemo.h"

bool FactoryDemo::init()
{
    if(!initSystem("Factory", 800, 600, false))
        return false;

    if(!map.load("graphics/platformer.map", "graphics/tiles.bmp"))
        return false;

    if(!buttonPanelImage.load("graphics/buttons.bmp"))
        return false;

    if(!cursorImage.load("graphics/cursor.bmp"))
        return false;

    if(!factory.init(&map))
        return false;

    camera.setSize(800, 600);
    camera.setX(0);
    camera.setY2(map.getTotalHeight()-1);

    buttonSelection = 0;

    getInput()->hideCursor(true);

    return true;
}

void FactoryDemo::free()
{
    scene.removeNode(NULL);
    buttonPanelImage.free();
    cursorImage.free();
    map.free();
    factory.free();
    freeSystem();
}

void FactoryDemo::update()
{
    Input* in = getInput();

    updateCamera();

    if(in->keyHit(SDLK_1))
        buttonSelection = 0;

    if(in->keyHit(SDLK_2))
        buttonSelection = 1;

    if(in->keyHit(SDLK_3))
        buttonSelection = 2;

    if(in->keyHit(SDLK_4))
        buttonSelection = 3;

    if(in->mouseHit(Input::MOUSE_LEFT))
    {
        int x = in->getMouseX() + camera.getX();
        int y = in->getMouseY() + camera.getY();

        switch(buttonSelection)
        {
            case 0:
                scene.addNode(factory.create(ENTITY_SOLDIER, x, y));
                break;
            case 1:
                scene.addNode(factory.create(ENTITY_SLUG, x, y));
                break;
            case 2:
                scene.addNode(factory.create(ENTITY_RIDER, x, y));
                break;
            case 3:
                scene.addNode(factory.create(ENTITY_FLIER, x, y));
                break;
            default:
                break;
        }
    }

    scene.update();
}

void FactoryDemo::draw(Graphics* g)
{
    g->clear(0, 255, 255);

    for(int i = 1; i < 4; i++)
    {
        map.draw(i, camera.getX(), camera.getY(), g);
    }

    scene.draw(&camera, g);

    buttonPanelImage.draw(BUTTON_PANEL_X, BUTTON_PANEL_Y, g);

    g->drawRect(BUTTON_PANEL_X + BUTTON_WIDTH*buttonSelection, BUTTON_PANEL_Y, BUTTON_WIDTH, BUTTON_HEIGHT, 0, 255, 0);

    int cursorX = getInput()->getMouseX() - cursorImage.getWidth()/2;
    int cursorY = getInput()->getMouseY() - cursorImage.getHeight()/2;
    cursorImage.draw(cursorX, cursorY, g);
}

void FactoryDemo::updateCamera()
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
}
