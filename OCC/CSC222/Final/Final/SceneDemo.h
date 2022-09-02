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
#include "Core/OutlineFont.h"

class SceneDemo : public Game
{
private:
    static const int PLAYER_SPEED = 15;
    static const int PLAYER_WIDTH = 67;            //your bitmap width may be different
    static const int PLAYER_HEIGHT = 60;           //your bitmap height may be different
    static const int PLAYER_X = 50;                 //you can place your player in a different position
    static const int PLAYER_Y = 50;                 //you can place your player in a different position

    //char playerLives[64];
   // char playerScore[64];

    Map map;
    Scene scene;
    Game* game;
    Rectangle camera;
    Player* player;
    Image playerImage;
    Image background;
   TTF_Font *GameFont = NULL;
    Factory factory;
    // were private
    virtual bool load();
    virtual void parseLine(ifstream* in);
public:
    int playerScore = 0;

    SceneDemo();
    ~SceneDemo();
    virtual bool init();
    virtual void update();
    virtual void draw(Graphics* g);
    virtual void free();


};

#endif
