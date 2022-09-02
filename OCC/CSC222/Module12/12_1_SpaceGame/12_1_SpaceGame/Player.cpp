#include "Player.h"

bool Player::init()
{
    entity = NULL;
    camera = NULL;
    deathDelay = 0;
    lives = 3;

    if(!lifeCounterImage.load("graphics/sprites/player_life.bmp"))
    {
        return false;
    }

    return true;
}

void Player::free()
{
    lifeCounterImage.free();
}

void Player::setEntity(PlayerEntity* n)
{
    entity = n;
}

void Player::setCamera(Rectangle* r)
{
    camera = r;
}

void Player::update(Input* i, Level* l)
{
    if(entity != NULL)
    {
        if(i->keyDown(SDLK_UP))
        {
            entity->moveUp();
        }

        if(i->keyDown(SDLK_DOWN))
        {
            entity->moveDown();
        }

        if(i->keyDown(SDLK_LEFT))
        {
            entity->moveLeft();
        }

        if(i->keyDown(SDLK_RIGHT))
        {
            entity->moveRight();
        }

        if(i->keyDown(SDLK_SPACE))
        {
            entity->shoot();
        }

        if(entity->getHealth() <= 0)
        {
            if(deathDelay == 0)
            {
                lives--;
            }

            deathDelay++;

            if(deathDelay >= 60)
            {
                deathDelay = 0;
                entity->respawn();
                camera->setCenterX(entity->getSpawnX());
                l->reset();
            }
        }
    }
}

void Player::draw(Graphics* g)
{
    int barWidth = entity->getHealth()*3;

    for(int i = 0; i < barWidth; i++)
    {
        int colorMod = ((float)i/LIFEBAR_WIDTH)*255;
        g->drawRect(LIFEBAR_X+i, LIFEBAR_Y, 1, LIFEBAR_HEIGHT, 255-colorMod, colorMod, 0);
    }

    g->drawRect(LIFEBAR_X, LIFEBAR_Y, LIFEBAR_WIDTH, LIFEBAR_HEIGHT, 255, 255, 255);
    g->drawRect(LIFEBAR_X-1,LIFEBAR_Y-1,LIFEBAR_WIDTH+2, LIFEBAR_HEIGHT+2, 0, 0, 0);

    for(int i = 0; i < lives; i++)
    {
        lifeCounterImage.draw(LIVES_PANEL_X+LIVES_SPACING*i, LIVES_PANEL_Y, g);
    }
}

void Player::scroll(int x)
{
    if(entity != NULL)
    {
        entity->setX(entity->getX() + x);
    }
}

int Player::getLives()
{
    return lives;
}
