#include <SDL/SDL.h>

//Initialization
SDL_Surface* Background = NULL;
SDL_Surface* Spaceship1 = NULL;
SDL_Surface* Spaceship2 = NULL;
SDL_Surface* Backbuffer = NULL;

SDL_Rect SpritePos;
SDL_Rect SpritePos2;

SDL_Surface* LoadImage(char* fileName);
bool LoadFiles();
void FreeFiles();
bool ProgramIsRunning();

int main(int argc, char* args[])
{
    // Displays error message if SDL does not initialize
    if(SDL_Init(SDL_INIT_EVERYTHING) < 0)
    {
        printf("Failed to initialize SDL!\n");
        return 0;
    }

    // Sets the window
    Backbuffer = SDL_SetVideoMode(800, 600, 32, SDL_SWSURFACE);

    SDL_WM_SetCaption("Color Keying", NULL);

    // Displays if images fail to load
    if(!LoadFiles())
    {
        printf("Failed to load files!\n");
        FreeFiles();
        SDL_Quit();

        return 0;
    }
    // Sets sprites in there starting position
    SpritePos.x = 0;
    SpritePos.y = 250;
    SpritePos2.x = 800;
    SpritePos2.y = 250;

    // Moves sprites across the screen
    while(ProgramIsRunning())
    {
        SpritePos.x+=5;

        // Moves sprite right to left (slower image)
        if(SpritePos.x == 800)
            SpritePos.x = 0;

        SDL_BlitSurface(Background, NULL, Backbuffer, NULL);
        SDL_BlitSurface(Spaceship1, NULL, Backbuffer, &SpritePos);

        // Moves sprite right to left (faster image)
        SpritePos2.x-=10;
        if(SpritePos2.x == 0)
            SpritePos2.x = 800;
        SDL_BlitSurface(Spaceship2, NULL, Backbuffer, &SpritePos2);

        SDL_Delay(20);
        SDL_Flip(Backbuffer);
    }

    FreeFiles();

    SDL_Quit();

    return 0;
}
// Loads image which are color keyed
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

// Loads images to be used
bool LoadFiles()
{
    Background = LoadImage("graphics/background.bmp");

    if(Background == NULL)
        return false;

    Spaceship1 = LoadImage("graphics/spaceship1.bmp");

    if(Spaceship1 == NULL)
        return false;

    Spaceship2 = LoadImage("graphics/spaceship2.bmp");

    if(Spaceship2 == NULL)
        return false;

    return true;
}

void FreeFiles()
{
    SDL_FreeSurface(Background);
    SDL_FreeSurface(Spaceship1);
    SDL_FreeSurface(Spaceship2);
}

// Determines if the program is running returning a boolean
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

