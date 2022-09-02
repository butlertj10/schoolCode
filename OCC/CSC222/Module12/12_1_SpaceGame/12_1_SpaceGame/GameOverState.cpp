#include "GameOverState.h"

bool GameOverState::init(GameState* r, Input* i)
{
    runState = r;
    input = i;

    if(!mainMenuButtonImage.load("graphics/menus/gameover/main_menu_button.bmp"))
        return false;

    if(!overlayImage.load("graphics/menus/gameover/overlay.bmp"))
        return false;

    mainMenuButton.setPos(BUTTON_X, BUTTON_Y);
    mainMenuButton.setImage(&mainMenuButtonImage);

    return true;
}

void GameOverState::free()
{
    mainMenuButtonImage.free();
    overlayImage.free();
}

void GameOverState::update()
{
    mainMenuButton.update(input);

    if(mainMenuButton.fired())
    {
        runState->free();
        getManager()->popState();
        getManager()->popState();
    }
}

void GameOverState::draw(Graphics* g)
{
    runState->draw(g);
    overlayImage.draw(0,0,g);
    mainMenuButton.draw(g);
}

