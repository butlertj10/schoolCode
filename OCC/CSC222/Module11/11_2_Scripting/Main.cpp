#include "ScriptDemo.h"

int main(int argc, char *argv[])
{
    ScriptDemo game;

    if(!game.init())
    {
        game.free();
        return 0;
    }

    game.run();

    return true;
}
