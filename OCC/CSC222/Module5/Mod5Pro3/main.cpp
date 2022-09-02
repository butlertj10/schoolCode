#include <SDL/SDL.h>

SDL_Surface* Background = NULL;
SDL_Surface* SpriteTurtle = NULL;
SDL_Surface* SpriteFish = NULL;
SDL_Surface* Backbuffer = NULL;

int TSpriteX = 350;
int TSpriteY = 250;
int TurtleW = 98;
int TurtleH = 98;
int FSpriteX = 100;
int FSpriteY = 250;
int FishW = 133;
int FishH = 64;

bool LoadFiles();
void FreeFiles();

SDL_Surface* LoadImage(char* fileName);
void CheckBorder(int& x, int& y, int w, int h);
void DrawImage(SDL_Surface* image, SDL_Surface* destSurface, int x, int y);
bool ProgramIsRunning();

int main(int argc, char* args[])
{
    if(SDL_Init(SDL_INIT_EVERYTHING) < 0)
        return false;

    Backbuffer = SDL_SetVideoMode(800, 600, 32, SDL_SWSURFACE);

    SDL_WM_SetCaption("Use the arrow keys to move the sprite around and ESC to exit.", NULL);

    if(!LoadFiles())
    {
        FreeFiles();
        SDL_Quit();
        return 0;
    }

    while(ProgramIsRunning())
    {
        //Handle Input
        Uint8* keys = SDL_GetKeyState(NULL);

        if(keys[SDLK_ESCAPE])
            break;

        if(keys[SDLK_LEFT])
            TSpriteX-=8;

        if(keys[SDLK_RIGHT])
            TSpriteX+=8;

        if(keys[SDLK_UP])
            TSpriteY-=8;

        if(keys[SDLK_DOWN])
            TSpriteY+=8;

        if(keys[SDLK_a])
            FSpriteX-=8;

        if(keys[SDLK_d])
            FSpriteX+=8;

        if(keys[SDLK_w])
            FSpriteY-=8;

        if(keys[SDLK_s])
            FSpriteY+=8;

        // Checks borders and allows bitmaps/background to be mapped to screen
        CheckBorder(TSpriteX, TSpriteY, TurtleW, TurtleH);
        CheckBorder(FSpriteX, FSpriteY, FishW, FishH);
        DrawImage(Background,Backbuffer, 0, 0);
        DrawImage(SpriteTurtle, Backbuffer, TSpriteX, TSpriteY);
        DrawImage(SpriteFish, Backbuffer, FSpriteX, FSpriteY);

        SDL_Delay(20);
        SDL_Flip(Backbuffer);
    }

    FreeFiles();

    SDL_Quit();

    return 1;
}

SDL_Surface* LoadImage(char* fileName)
{
    SDL_Surface* imageLoaded = NULL;
    SDL_Surface* processedImage = NULL;

    imageLoaded = SDL_LoadBMP(fileName);

    if(imageLoaded != NULL)
    {
        processedImage = SDL_DisplayFormat(imageLoaded);
        SDL_FreeSurface(imageLoaded);

        if( processedImage != NULL )
        {
            Uint32 colorKey = SDL_MapRGB( processedImage->format, 255, 255, 255 );
            SDL_SetColorKey( processedImage, SDL_SRCCOLORKEY, colorKey );
        }

    }

    return processedImage;
}

void DrawImage(SDL_Surface* image, SDL_Surface* destSurface, int x, int y)
{
    SDL_Rect destRect;
    destRect.x = x;
    destRect.y = y;

    SDL_BlitSurface( image, NULL, destSurface, &destRect);
}

bool ProgramIsRunning()
{
    SDL_Event event;

    bool running = true;

    while(SDL_PollEvent(&event))
    {
        if(event.type == SDL_QUIT)
            running = false;
    }

    return running;
}

bool LoadFiles()
{
    SpriteTurtle = LoadImage("graphics/turtle.bmp");

    if(SpriteTurtle == NULL)
        return false;

    SpriteFish = LoadImage("graphics/fish.bmp");

    if(SpriteFish == NULL)
        return false;

    Background = LoadImage("graphics/reef.bmp");

    if(Background == NULL)
        return false;

    return true;

}

void FreeFiles()
{
    if(SpriteTurtle != NULL)
    {
        SDL_FreeSurface(SpriteTurtle);
        SpriteTurtle = NULL;
    }

    if(SpriteFish != NULL)
    {
        SDL_FreeSurface(SpriteFish);
        SpriteFish = NULL;
    }

    if(Background != NULL)
    {
        SDL_FreeSurface(Background);
        Background = NULL;
    }
}

void CheckBorder(int& x, int& y, int w, int h)
{
    int spriteW = w;
    int spriteH = h;

    //IF the sprite has collided with the right side THEN
    if(x > (800-spriteW))
    {
        x = (800 - spriteW);
    }

    //IF the sprite has collided with the left side THEN
    if(x <= 0)
    {
        x = 0;
    }

    //IF the sprite has collided with the bottom THEN
    if(y > (600 - spriteH))
    {
        y = (600 - spriteH);
    }

    //IF the sprite has collided with the top THEN
    if(y <= 0)
    {
        y = 0;
    }
}
