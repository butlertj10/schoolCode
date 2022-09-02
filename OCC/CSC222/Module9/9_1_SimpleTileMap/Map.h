#ifndef MAP_H
#define MAP_H

#include "Core/Graphics.h"
#include "Core/Image.h"

class Map
{
private:
    Image tiles;
    int tileWidth;
    int tileHeight;
    int width;
    int height;
public:
    Map();
    ~Map();

    bool init(char imageName[]);
    void draw(Graphics* g);
    void free();
};

#endif
