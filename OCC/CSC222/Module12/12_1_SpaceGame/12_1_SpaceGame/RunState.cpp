#include "RunState.h"

bool RunState::init(Input* i, Audio* a, int width, int height)
{
    camera.set(0, 0, width, height);

    if(!loadFiles())
        return false;

    if(!gameEndingState.init(this, i))
        return false;

    if(!gameOverState.init(this,i))
        return false;

    if(!pauseState.init(this, i))
        return false;

    if(!player.init())
        return false;

    if(!factory.init())
        return false;

    factory.setCamera(&camera);
    player.setCamera(&camera);

    if(!initLevel())
        return false;

    input = i;
    audio = a;

    song.play(-1);

    return true;
}

void RunState::free()
{
    audio->stopMusic();
    freeFiles();
    gameEndingState.free();
    gameOverState.free();
    level.free();
    pauseState.free();
}

bool RunState::loadFiles()
{
    if(!background1.load("graphics/backgrounds/stars1.bmp"))
    {
        return false;
    }

    if(!background2.load("graphics/backgrounds/stars2.bmp"))
    {
        return false;
    }

    if(!background3.load("graphics/backgrounds/space.bmp"))
    {
        return false;
    }

    if(!song.load("audio/music/gamesong.mp3"))
    {
        return false;
    }

    return true;
}

void RunState::freeFiles()
{
    background1.free();
    background2.free();
    background3.free();
    song.free();
}

void RunState::drawBackground(Graphics* g)
{
    background3.draw(0-(camera.getX()/8)%g->getWidth(), camera.getY(), g);
    background3.draw(0-(camera.getX()/8)%g->getWidth() + g->getWidth(), camera.getY(), g);

    background2.draw(0-(camera.getX()/4)%g->getWidth(), camera.getY(), g);
    background2.draw(0-(camera.getX()/4)%g->getWidth() + g->getWidth(), camera.getY(), g);

    background1.draw(0-(camera.getX()/2)%g->getWidth(), camera.getY(), g);
    background1.draw(0-(camera.getX()/2)%g->getWidth() + g->getWidth(), camera.getY(), g);
}

bool RunState::initLevel()
{
    if(!level.load("levels/level1.txt", &factory))
    {
        return false;
    }

    PlayerEntity* playerEntity = (PlayerEntity*)factory.makeEntity(ENTITY_PLAYER, level.getSpawnX(), level.getSpawnY());

    level.getScene()->addNode(playerEntity);
    player.setEntity(playerEntity);

    return true;
}

void RunState::update()
{
    camera.setX(camera.getX()+10);

    if(camera.getX2() >= level.getMap()->getTotalWidth())
        camera.setX2(level.getMap()->getTotalWidth());
    else
        player.scroll(10);

    player.update(input, &level);
    level.update();

    if(input->keyHit(SDLK_ESCAPE))
    {
        getManager()->addState(&pauseState);
    }

    if(player.getLives() <= 0)
    {
        getManager()->addState(&gameOverState);
    }

    if(level.getBoss()->isDead() || input->keyHit(SDLK_a))
    {
        getManager()->addState(&gameEndingState);
    }
}

void RunState::draw(Graphics* g)
{
    g->clear(0, 0, 0);

    drawBackground(g);
    level.draw(&camera, g);
    player.draw(g);
}
