#include "SceneDemo.h"

SceneDemo::SceneDemo()
{
}

SceneDemo::~SceneDemo()
{

}

bool SceneDemo::init()
{
    if(!initSystem("UFO Maze", 800, 600, false))
        return false;

    if(!map.load("graphics/map.map", "graphics/tiles.bmp"))
        return false;

    if(!playerImage.load("graphics/sprites/UFO.bmp", 67, 60))  //load the sprite bitmap 64 72
        return false;

    if(!background.load("graphics/background.bmp"))
        return false;

    GameFont = TTF_OpenFont("graphics/brick.ttf", 20);

    if(GameFont == NULL)
        return false;

    if (!factory.init(&map))
        return false;

    if(!load())
        return false;

   // OutlineFont.draw("test", 15, 15, 255, 255, 255, g);

    player = new Player(ENTITY_PLAYER, PLAYER_X, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT, true, &map, &playerImage);


    scene.addNode(player);
   //scene.addNode(factory.create(ENTITY_RIDER, 200, 850));
    //scene.addNode (factory.create(ENTITY_RIDER, 760, 500));
   // scene.addNode(factory.create(ENTITY_RIDER, 100, 100));

    camera.set(0,0,800,600);

    return true;
}

void SceneDemo::update()
{
    scene.update();

    Input* in = getInput();

    int playerMoveX = 0;
    int playerMoveY = 0;

    if(in->keyDown(SDLK_w))
        playerMoveY = -PLAYER_SPEED;

    if(in->keyDown(SDLK_s))
        playerMoveY = PLAYER_SPEED;

    if(in->keyDown(SDLK_a))
        playerMoveX = -PLAYER_SPEED;

    if(in->keyDown(SDLK_d))
        playerMoveX = PLAYER_SPEED;

    player->move(playerMoveX, playerMoveY);

    camera.setCenterX(player->getCenterX());
    camera.setCenterY(player->getCenterY());

    if(camera.getX() < 0)
        camera.setX(0);

    if(camera.getY() < 0)
        camera.setY(0);

    if(camera.getX2() >= map.getTotalWidth())
        camera.setX2(map.getTotalWidth() - 1);

    if(camera.getY2() >= map.getTotalHeight())
        camera.setY2(map.getTotalHeight() - 1);

    if(player->getX() < 0)
        player->setX(0);

    if(player->getY() < 0)
        player->setY(0);

    if(player->getX2() >= map.getTotalWidth())
        player->setX2(map.getTotalWidth() - 1);

    if(player->getY2() >= map.getTotalHeight())
        player->setY2(map.getTotalHeight() - 1);
}

// Loads script
bool SceneDemo::load()
{
    ifstream in("script.txt");

    if(!in.good())
    {
        return false;
    }

    while(!in.eof())
    {
        parseLine(&in);
    }

    in.close();

    return true;
}

// Loads players coordinated and add them to screen
void SceneDemo::parseLine(ifstream* in)
{
    char command[64];
    (*in)>>command;

    if(!strcmp(command, "soldier"))
    {
        int x;
        int y;

        (*in)>>x;
        (*in)>>y;

        scene.addNode(factory.create(ENTITY_BLUE_SOLDIER, x, y));
    }

    if(!strcmp(command, "slug"))
    {
        int x;
        int y;

        (*in)>>x;
        (*in)>>y;

        scene.addNode(factory.create(ENTITY_GREEN_SOLDIER, x, y));
    }

    if(!strcmp(command, "rider"))
    {
        int x;
        int y;

        (*in)>>x;
        (*in)>>y;

        scene.addNode(factory.create(ENTITY_YELLOW_SOLDIER, x, y));
    }

    if(!strcmp(command, "flier"))
    {
        int x;
        int y;

        (*in)>>x;
        (*in)>>y;

        scene.addNode(factory.create(ENTITY_RED_SOLDIER, x, y));
    }
}


void SceneDemo::draw(Graphics* g)
{
   // g->clear(0, 0, 0);

   // for(int i = 1; i < 4; i++)
    //{
     //   map.draw(i, camera.getX(), camera.getY(), g);
    //}

    background.draw(0,0, g);
    map.draw(1, camera.getX(), camera.getY(), g);
    map.draw(2, camera.getX(), camera.getY(), g);
    map.draw(0, camera.getX(), camera.getY(), g);
    scene.draw(&camera, g);
}

void SceneDemo::free()
{
    scene.removeNode(NULL);
    TTF_CloseFont(GameFont);

    map.free();
    factory.free();
    background.free();
    freeSystem();
}

