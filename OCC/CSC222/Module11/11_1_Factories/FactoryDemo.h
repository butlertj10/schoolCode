#include "Core/Game.h"
#include "Core/Image.h"
#include "Core/Map.h"
#include "Core/Rectangle.h"
#include "Core/Scene.h"
#include "Factory.h"

class FactoryDemo : public Game
{
private:
    static const int CAM_SPEED = 10;
    static const int BUTTON_PANEL_X = 20;
    static const int BUTTON_PANEL_Y = 20;
    static const int BUTTON_HEIGHT = 50;
    static const int BUTTON_WIDTH = 50;

    Map map;
    Rectangle camera;
    Scene scene;
    Image buttonPanelImage;
    Image cursorImage;
    Factory factory;

    int buttonSelection;
	void updateCamera();
public:
    bool init();
    void free();
    void draw(Graphics* g);
    void update();
};
