#include <SDL/SDL.h>

int Cross1X = -100;
int Cross1Y = -100;
int Cross2X = -100;
int Cross2Y = -100;

SDL_Surface* Cross1 = NULL;
SDL_Surface* Cross2 = NULL;
SDL_Surface* Background = NULL;
SDL_Surface* Backbuffer = NULL;

bool LoadFiles();
void FreeFiles();

SDL_Surface* LoadImage(char* fileName);
void DrawImage(SDL_Surface* image, SDL_Surface* destSurface, int x, int y);
bool ProgramIsRunning();

int main(int argc, char* args[])
{
    SDL_Init(SDL_INIT_EVERYTHING);

    Backbuffer = SDL_SetVideoMode(800, 600, 32, SDL_SWSURFACE);

    if(!LoadFiles())
    {
        FreeFiles();
        SDL_Quit();

        return 0;
    }

    while(ProgramIsRunning())
    {
        int mouseX;
        int mouseY;

        SDL_GetMouseState(&mouseX, &mouseY);

        char buffer[64];
        sprintf(buffer, "Mouse X: %d, Mouse Y: %d", mouseX, mouseY);
        SDL_WM_SetCaption(buffer, NULL);

        //Process Buttons;
        if(SDL_GetMouseState(NULL,NULL) & SDL_BUTTON(1))
        {
            Cross1X = mouseX;
            Cross1Y = mouseY;
        }

        if(SDL_GetMouseState(NULL,NULL) & SDL_BUTTON(3))
        {
            Cross2X = mouseX;
            Cross2Y = mouseY;
        }

        DrawImage(Background, Backbuffer, 0, 0);
        DrawImage(Cross1, Backbuffer, Cross1X - 50, Cross1Y - 50);
        DrawImage(Cross2, Backbuffer, Cross2X - 50, Cross2Y - 50);

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
    Cross1 = LoadImage("graphics/cross_1.bmp");

    if(Cross1 == NULL)
        return false;

    Cross2 = LoadImage("graphics/cross_2.bmp");

    if(Cross2 == NULL)
        return false;

    Background = LoadImage("graphics/background.bmp");

    if(Background == NULL)
        return false;

    return true;

}

void FreeFiles()
{
    if(Cross1 != NULL)
    {
        SDL_FreeSurface(Cross1);
        Cross1 = NULL;
    }

    if(Cross2 != NULL)
    {
        SDL_FreeSurface(Cross2);
        Cross2 = NULL;
    }

    if(Background != NULL)
    {
        SDL_FreeSurface(Background);
        Background = NULL;
    }
}
