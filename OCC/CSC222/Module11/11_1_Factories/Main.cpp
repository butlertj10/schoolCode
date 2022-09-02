#include "FactoryDemo.h"

int main(int argc, char *argv[])
{
    FactoryDemo game;

    if(!game.init())
    {
        game.free();
        return 0;
    }

    game.run();

    return true;
}
