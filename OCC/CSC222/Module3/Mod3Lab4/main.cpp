#include <SDL/SDL.h>

SDL_Surface* Background = NULL;
SDL_Surface* SpriteImage = NULL;
SDL_Surface* Backbuffer = NULL;

int SpriteFrame = 0;
int FrameCounter = 0;

const int MaxSpriteFrame = 12;
const int FrameDelay = 2;

int SpriteLocation = 0;

SDL_Surface* LoadImage(char* fileName);
bool LoadFiles();
void FreeFiles();
void DrawImage(SDL_Surface* image, SDL_Surface* destSurface, int x, int y);
void DrawImageFrame(SDL_Surface* image, SDL_Surface* destSurface, int x, int y, int width, int height, int frame);
bool ProgramIsRunning();

int main(int argc, char* args[])
{
    if(SDL_Init(SDL_INIT_EVERYTHING) < 0)
    {
        printf("Failed to initialize SDL!\n");
        return 0;
    }

    Backbuffer = SDL_SetVideoMode(800, 600, 32, SDL_SWSURFACE);

    SDL_WM_SetCaption("Bat Animation", NULL);

    if(!LoadFiles())
    {
        printf("Failed to load all files!\n");
        FreeFiles();
        SDL_Quit();

        return 0;
    }

    while(ProgramIsRunning())
    {
        //Updates the sprites frame
        FrameCounter++;

        if(FrameCounter > FrameDelay)
        {
            FrameCounter = 0;
            SpriteFrame++;
        }

        if(SpriteFrame > MaxSpriteFrame)
            SpriteFrame = 0;

        //Updates Bat location if at end
        if(SpriteLocation == 800)
           SpriteLocation = 0;

        //Render the scene
        DrawImage(Background,Backbuffer, 0, 0);
        DrawImageFrame(SpriteImage, Backbuffer, SpriteLocation+=5,250, 32, 32, SpriteFrame);

        SDL_Delay(22);
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
            Uint32 colorKey = SDL_MapRGB(processedImage->format, 255, 255, 255);
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

    SpriteImage = LoadImage("graphics/bats.bmp");

    if(SpriteImage == NULL)
        return false;

    return true;
}

void FreeFiles()
{
    SDL_FreeSurface(Background);
    SDL_FreeSurface(SpriteImage);
}

void DrawImage(SDL_Surface* image, SDL_Surface* destSurface, int x, int y)
{
    SDL_Rect destRect;
    destRect.x = x;
    destRect.y = y;

    SDL_BlitSurface(image, NULL, destSurface, &destRect);
}

void DrawImageFrame(SDL_Surface* image, SDL_Surface* destSurface, int x, int y, int width, int height, int frame)
{
    SDL_Rect destRect;
    destRect.x = x;
    destRect.y = y;

    int columns = image->w/width;

    SDL_Rect sourceRect;
    sourceRect.y = (frame/columns)*height;
    sourceRect.x = (frame%columns)*width;
    sourceRect.w = width;
    sourceRect.h = height;

    SDL_BlitSurface(image, &sourceRect, destSurface, &destRect);
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
