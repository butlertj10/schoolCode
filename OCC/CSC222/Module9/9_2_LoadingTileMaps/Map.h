#ifndef MAP_H
#define MAP_H

#include "Core/Graphics.h"
#include "Core/Image.h"
#include <fstream>

class Map
{
private:
    Image tiles;
    int tileWidth;
    int tileHeight;
    int width;
    int height;
    int* data;
public:
    Map();
    ~Map();

    bool load(char mapName[], char imageName[]);
    void draw(Graphics* g);
    void free();
};

#endif
