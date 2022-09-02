#ifndef SCRIPTDEMO_H
#define SCRIPTDEMO_H

#include <fstream>

#include "Core/Game.h"
#include "Core/Image.h"
#include "Core/Map.h"
#include "Core/Rectangle.h"
#include "Core/Scene.h"
#include "Factory.h"

class ScriptDemo : public Game
{
private:
    static const int CAM_SPEED = 15;
    static const int BUTTON_PANEL_X = 20;
    static const int BUTTON_PANEL_Y = 20;
    static const int BUTTON_HEIGHT = 50;
    static const int BUTTON_WIDTH = 50;

    Map map;
    Rectangle camera;
    Scene scene;
    Image cursorImage;
    Factory factory;

    bool load();
    void parseLine(ifstream* in);
public:
    bool init();
    void free();
    void draw(Graphics* g);
    void update();
};

#endif
