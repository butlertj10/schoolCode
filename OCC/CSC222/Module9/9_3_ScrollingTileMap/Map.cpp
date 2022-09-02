#include "Map.h"

Map::Map()
{
    tileWidth = -1;
    tileHeight = -1;
    width = -1;
    height = -1;
    data = NULL;
}

Map::~Map()
{

}

bool Map::load(char mapName[], char imageName[])
{
    data = NULL;

    std::ifstream in(mapName);

    if(!in.good())
        return false;

    std::string buffer;

    //Get the line that says 'width'
    getline(in, buffer, ' ');
    //Get the width value
    getline(in, buffer, '\n');
    width = atoi(buffer.c_str());

    //Get the line that says 'height'
    getline(in, buffer, ' ');
    //Get the width value
    getline(in, buffer, '\n');
    height = atoi(buffer.c_str());

    //Get the line that says 'tile_width'
    getline(in, buffer, ' ');
    //Get the width value
    getline(in, buffer, '\n');
    tileWidth = atoi(buffer.c_str());

    //Get the line that says 'tile_height'
    getline(in, buffer, ' ');
    //Get the width value
    getline(in, buffer, '\n');
    tileHeight = atoi(buffer.c_str());

    //Get the line taht says 'solid_tiles' and ignore it
    getline(in, buffer, '\n');
    //Get the row containing solid tiles and ignore it
    getline(in, buffer, '\n');
    //Get the row containing 'layer1' and ignore it
    getline(in, buffer, '\n');

    //Get the tile data
    data = new int[width * height];

    int i = 0;
    for(int y = 0; y < height; y++)
    {
        for(int x = 0; x < width; x++)
        {
            char delim = ',';

            if(x == width-1)
                delim = '\n';

            getline(in, buffer, delim);
            data[i] = atoi(buffer.c_str());
            i++;
        }
    }

    in.close();

    //Load Image
    if(!tiles.load(imageName, tileWidth, tileHeight))
        return false;

    return true;
}

void Map::draw(int xOffset, int yOffset, Graphics* g)
{
    int startY = yOffset/tileHeight;
    int startX = xOffset/tileWidth;

    int rows = (g->getHeight()/tileHeight) + 2;
    int columns = (g->getWidth()/tileWidth) + 2;

    for(int y = startY; y < startY+rows; y++)
        for(int x = startX; x < startX+columns; x++)
        {
            int frame = -1;

            if(x >= 0 && y >= 0 && x < width && y < height)
                frame = data[y*width+x]-1;

            if(frame >= 0)
                tiles.draw(x*tileWidth - xOffset, y*tileHeight - yOffset, frame, g);
        }
}

void Map::free()
{
    if(data != NULL)
    {
        delete[] data;
        data = NULL;
    }
    tiles.free();
}

