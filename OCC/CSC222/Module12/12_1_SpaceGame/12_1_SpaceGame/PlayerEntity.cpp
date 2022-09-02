#include "PlayerEntity.h"

PlayerEntity::PlayerEntity(Image* image, Map* m, Rectangle* c, int x, int y, EntityFactory* f) :
    MapNode(ENTITY_PLAYER, x - ENTITY_WIDTH/2,
            y - ENTITY_HEIGHT/2,
            ENTITY_WIDTH, ENTITY_HEIGHT, true, m)
{
    sprite.setImage(image);

    camera = c;
    factory = f;
    xVel = yVel = 0;
    gunCooldown = 0;
    health = 100;
    startX = x;
    startY = y;
}

PlayerEntity::~PlayerEntity()
{

}

void PlayerEntity::moveUp()
{
    yVel-=ACCEL;
}

void PlayerEntity::moveDown()
{
    yVel+=ACCEL;
}

void PlayerEntity::moveLeft()
{
    xVel-=ACCEL;
}

void PlayerEntity::moveRight()
{
    xVel+=ACCEL;
}

void PlayerEntity::respawn()
{
    setX(startX);
    setY(startY);
    xVel = 0;
    yVel = 0;
    sprite.setFrame(NUM_FRAMES/2+1);
    health = 100;
}

void PlayerEntity::setSpawn(int x, int y)
{
    startX = x;
    startY = y;
}

int PlayerEntity::getSpawnX()
{
    return startX;
}

void PlayerEntity::update()
{
    if(health <= 0)
        return;

    gunCooldown--;

    if(xVel > MAX_VEL)
        xVel = MAX_VEL;

    if(xVel < -MAX_VEL)
        xVel = -MAX_VEL;

    if(yVel > MAX_VEL)
        yVel = MAX_VEL;

    if(yVel < -MAX_VEL)
        yVel = -MAX_VEL;

    if(yVel > 0)
        yVel--;

    if(yVel < 0)
        yVel++;

    if(xVel > 0)
        xVel--;

    if(xVel < 0)
        xVel++;

    int middleFrame = NUM_FRAMES/2;

    if(yVel == 0)
    {
        sprite.setFrame(middleFrame);
    }
    else if(yVel > 0)
    {
        sprite.setFrame(middleFrame + 1 + (NUM_FRAMES/2)*((float)yVel/MAX_VEL));
    }
    else
    {
        sprite.setFrame(middleFrame + (NUM_FRAMES/2)*((float)yVel/MAX_VEL));
    }

    sprite.update();

    setY(getY() + yVel);
    setX(getX() + xVel);

    if(getY() <= camera->getY())
        setY(camera->getY());

    if(getX() <= camera->getX())
        setX(camera->getX());

    if(getY2() >= camera->getY2())
        setY2(camera->getY2());

    if(getX2() >= camera->getX2())
        setX2(camera->getX2());

    if(overlapsMap())
    {
        getScene()->addNode(factory->makeEntity(ENTITY_EXPLOSION, getX() + rand()%getWidth(), getY() + rand()%getHeight()));

        for(int i = 0; i < 10; i++)
            getScene()->addNode(factory->makeEntity(ENTITY_SILENT_EXPLOSION, getX() + rand()%getWidth(), getY() + rand()%getHeight()));

        health = 0;
    }

    if(health < 30)
        getScene()->addNode(factory->makeEntity(ENTITY_SMALL_EXPLOSION, getX() + rand()%getWidth(), getY() + rand()%getHeight()));
}

void PlayerEntity::damage(int d)
{
    health -= d;

    if(health < 0)
        health = 0;

    for(int i = 0; i < 5; i++)
        getScene()->addNode(factory->makeEntity(ENTITY_SMALL_EXPLOSION, getX() + rand()%getWidth(), getY() + rand()%getHeight()));
}

int PlayerEntity::getHealth()
{
    return health;
}

void PlayerEntity::shoot()
{
    if(gunCooldown <= 0)
    {
        getScene()->addNode(factory->makeEntity(ENTITY_PLAYER_BULLET, getX2(), getCenterY()+20));
        gunCooldown = GUN_COOLDOWN_TIME;
    }
}

void PlayerEntity::draw(Rectangle* view, Graphics* g)
{
    if(health <= 0)
        return;

    sprite.draw(getCenterX() - sprite.getWidth()/2 - view->getX(), getCenterY() - sprite.getHeight()/2 - view->getY(), g);
}
