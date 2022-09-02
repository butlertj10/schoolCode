#ifndef PLAYERNODE_H
#define PLAYERNODE_H

#include "Core/Rectangle.h"
#include "Core/MapNode.h"
#include "Core/Sprite.h"

#include "EntityDef.h"
#include "EntityFactory.h"

class EntityFactory;

class PlayerEntity : public MapNode
{
private:
    static const int ENTITY_WIDTH = 120;
    static const int ENTITY_HEIGHT = 60;
    static const int ACCEL = 3;
    static const int GUN_COOLDOWN_TIME = 6;
    static const int MAX_VEL = 10;
    static const int NUM_FRAMES = 7;

    EntityFactory* factory;
    Sprite sprite;
    Rectangle* camera;

    int xVel;
    int yVel;
    int startX;
    int startY;
    int health;
    int gunCooldown;
public:
    PlayerEntity(Image* image, Map* m, Rectangle* c, int x, int y, EntityFactory* f);
    ~PlayerEntity();

    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
    void shoot();
    void respawn();
    void setSpawn(int x, int y);
    int getSpawnX();

    void damage(int d);
    int getHealth();

    void update();
    void draw(Rectangle* view, Graphics* g);
};

#endif
