#ifndef MAPDEMO_H
#define MAPDEMO_H

#include "Core/Game.h"
#include "Core/Image.h"
#include "Core/Scene.h"
#include "Core/Rectangle.h"
#include "Core/Map.h"
#include "Core/MapNode.h"
#include "Factory.h"
#include "Player.h"
#include "NPC.h"
#include "ExplosionEntity.h"
//#include "Core/OutlineFont.h"

class SceneDemo : public Game
{
private:
    static const int PLAYER_SPEED = 10;
    static const int PLAYER_WIDTH = 64;            //your bitmap width may be different
    static const int PLAYER_HEIGHT = 72;           //your bitmap height may be different
    static const int PLAYER_X = 100;                 //you can place your player in a different position
    static const int PLAYER_Y = 500;                 //you can place your player in a different position

   // char playerLives[64];
    //char playerScore[64];

    Map map;
    Scene scene;
    Game* game;
    Rectangle camera;
    Player* player;
    Image playerImage;
    Image background;
    //TTF_Font *GameFont = NULL;
    Factory factory;

public:
    SceneDemo();
    ~SceneDemo();
    virtual bool init();
    virtual void update();
    virtual void draw(Graphics* g);
    virtual void free();

    // were private
   //virtual bool load();
    //virtual void parseLine(ifstream* in);
};

#endif
