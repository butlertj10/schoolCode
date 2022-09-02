#include <SDL/SDL.h>

SDL_Surface* Background = NULL;
SDL_Surface* SpriteImage = NULL;
SDL_Surface* Backbuffer = NULL;
SDL_Rect SpritePos;

SDL_Rect SpriteX;
SDL_Rect SpriteY;
int dirX, dirY, xDirection, yDirection, xPos, yPos, x, y;
const int ScreenHeight = 600;
const int ScreenWidth = 800;
const int BMWidth = 120;
const int BMHeight = 95;


bool LoadFiles();
void FreeFiles();

SDL_Surface* LoadImage(char* fileName);
void moveBitMap(int& xPosition, int& yPosition, int width, int height, int& xDirection, int& yDirection);
void DrawImage(SDL_Surface* image, SDL_Surface* destSurface, int x, int y);
bool ProgramIsRunning();

int main(int argc, char* args[])
{
    if(SDL_Init(SDL_INIT_EVERYTHING) < 0)
        return false;

    Backbuffer = SDL_SetVideoMode(ScreenWidth, ScreenHeight, 32, SDL_SWSURFACE);

    SDL_WM_SetCaption("Use the arrow keys to direct the ship and ESC to exit.", NULL);

    if(!LoadFiles())
    {
        FreeFiles();
        SDL_Quit();
        return 0;
    }

    dirX = 1;
    dirY = 1;
    xPos = 0;
    yPos = 0;
    SpriteX.x = xPos;
    SpriteY.y = yPos;

    while(ProgramIsRunning())
    {
        //Handle Input
        Uint8* keys = SDL_GetKeyState(NULL);

        //dirX = xDirection;
       //dirY = yDirection;

        if(keys[SDLK_ESCAPE])
            break;

        // moves bitmap left
        if(keys[SDLK_LEFT])
        {
            dirX = -1;
        }

        // moves bitmap right
        if(keys[SDLK_RIGHT])
        {
            dirX = 1;
        }

        // moves bitmap up
        if(keys[SDLK_UP])
        {
            dirY = -1;
        }

        // moves bitmap down
        if(keys[SDLK_DOWN])
        {
            dirY = 1;
        }

        xPos = SpritePos.x;
        yPos = SpritePos.y;
        moveBitMap(xPos, yPos, BMWidth, BMHeight, dirX, dirY);         //move the bitmap
        SpritePos.x = xPos;       //update x with new position
        SpritePos.y = yPos;       //update y with new position
        SDL_BlitSurface(Background, NULL, Backbuffer, NULL);           //Blit background to buffer

        DrawImage(Background,Backbuffer, 0, 0);
        DrawImage(SpriteImage, Backbuffer, SpritePos.x, SpritePos.y);

        SDL_Delay(5);
        SDL_Flip(Backbuffer);
    }

    FreeFiles();

    SDL_Quit();

    return 1;
}
//*****************************************************************************************//
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

void moveBitMap(int& xPosition, int& yPosition, int width, int height, int& xDirection, int& yDirection)
{
    // Calculate new x position with x direction value
        xPosition = xPosition + xDirection;

        // left/right
        // Determine if the bitmap is going beyond the right border
        if(xPosition > (ScreenWidth - width))
        {
            // Stops and reverse direction
            //xPosition = ScreenWidth - width;
            xDirection = -1;
        }

        // Determine if the bitmap is going beyond the left border
        if(xPosition <= 0)
        {
            //xPosition = 0;
            xDirection = 1;
        }

        // Calculate a new y position with y direction value
        yPosition = yPosition + yDirection;

        // up/down
        // Determine if the Bitmap is going below the bottom border
        if(yPosition > (ScreenHeight - height))
        {
           // may have to sub 1-4 pixels
           //yPosition = ScreenHeight - height;
           yDirection = -1;
        }

        // Determine if the bitmap is going beyond the top border
        if(yPosition <= 0)
        {
            //yPosition = 0;
            yDirection = 1;
        }
}
