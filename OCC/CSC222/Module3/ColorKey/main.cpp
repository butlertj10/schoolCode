
#include <SDL/SDL.h>

SDL_Surface* Background = NULL;
SDL_Surface* SpriteImage = NULL;
SDL_Surface* Backbuffer = NULL;

SDL_Rect SpritePos;

SDL_Surface* LoadImage(char* fileName);
bool LoadFiles();
void FreeFiles();
bool ProgramIsRunning();

int main(int argc, char* args[])
{
    if(SDL_Init(SDL_INIT_EVERYTHING) < 0)
    {
        printf("Failed to initialize SDL!\n");
        return 0;
    }

    Backbuffer = SDL_SetVideoMode(800, 600, 32, SDL_SWSURFACE);

    SDL_WM_SetCaption("Color Keying", NULL);

    if(!LoadFiles())
    {
        printf("Failed to load files!\n");
        FreeFiles();
        SDL_Quit();

        return 0;
    }

    SpritePos.x = 0;
    SpritePos.y = 250;

    while(ProgramIsRunning())
    {
        SpritePos.x+=5;

        if(SpritePos.x > 800)
            SpritePos.x = -200;

        SDL_BlitSurface(Background, NULL, Backbuffer, NULL);
        SDL_BlitSurface(SpriteImage, NULL, Backbuffer, &SpritePos);

        SDL_Delay(20);
        SDL_Flip(Backbuffer);
    }

    FreeFiles();

    SDL_Quit();

    return 0;
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

        if(processedImage != NULL)
        {
            Uint32 colorKey = SDL_MapRGB(processedImage->format, 255, 0, 255);
            SDL_SetColorKey(processedImage, SDL_SRCCOLORKEY, colorKey);
        }

    }

    return processedImage;
}


bool LoadFiles()
{
    Background = LoadImage("graphics/background.bmp");

    if(Background == NULL)
        return false;

    SpriteImage = LoadImage("graphics/spaceship.bmp");

    if(SpriteImage == NULL)
        return false;

    return true;
}

void FreeFiles()
{
    SDL_FreeSurface(Background);
    SDL_FreeSurface(SpriteImage);
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
