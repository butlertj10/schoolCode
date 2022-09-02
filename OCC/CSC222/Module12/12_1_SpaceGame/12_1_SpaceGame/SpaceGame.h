#ifndef SPACEGAME_H
#define SPACEGAME_H

#include "Core/Game.h"
#include "Core/StateManager.h"
#include "MainMenuState.h"
#include "RunState.h"

class SpaceGame : public Game
{
private:
    const static int SCREEN_WIDTH = 1024;
    const static int SCREEN_HEIGHT = 768;

    StateManager stateManager;
    MainMenuState mainMenuState;
    RunState runState;
public:
    bool init();
    void free();
    void update();
    void draw(Graphics* g);
};

#endif
