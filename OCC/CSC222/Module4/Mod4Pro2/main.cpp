#include <SDL/SDL.h>

SDL_Surface* Background = NULL;
SDL_Surface* SpriteImage = NULL;
SDL_Surface* Backbuffer = NULL;

int SpriteX = 350;
int SpriteY = 250;
int SpriteW = 120;
int SpriteH = 95;

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
            SpriteX-=8;

        if(keys[SDLK_RIGHT])
            SpriteX+=8;

        if(keys[SDLK_UP])
            SpriteY-=8;

        if(keys[SDLK_DOWN])
            SpriteY+=8;

        CheckBorder(SpriteX, SpriteY, SpriteW, SpriteH);
        DrawImage(Background,Backbuffer, 0, 0);
        DrawImage(SpriteImage, Backbuffer, SpriteX, SpriteY);

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
            Uint32 colorKey = SDL_MapRGB( processedImage->format, 0xFF, 0, 0xFF );
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
    SpriteImage = LoadImage("graphics/spaceship.bmp");

    if(SpriteImage == NULL)
        return false;

    Background = LoadImage("graphics/background.bmp");

    if(Background == NULL)
        return false;

    return true;

}

void FreeFiles()
{
    if(SpriteImage != NULL)
    {
        SDL_FreeSurface(SpriteImage);
        SpriteImage = NULL;
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
