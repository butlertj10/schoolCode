#include <SDL/SDL.h>

SDL_Surface* Background = NULL;
SDL_Surface* SpriteImage = NULL;
SDL_Surface* Backbuffer = NULL;
SDL_Rect SpritePos;

int SpriteFrame = 0;
int FrameCounter = 0;

const int MaxSpriteFrame = 12;
const int FrameDelay = 2;
const int BMWidth = 32;
const int BMHeight = 32;
const int ScreenHeight = 600;
const int ScreenWidth = 800;

int SpriteLocationX = 0;
int SpriteLocationY = 0;
int dirX, dirY, xDirection, yDirection, xPosition, yPosition;

SDL_Surface* LoadImage(char* fileName);
bool LoadFiles();
void FreeFiles();
void DrawImageFrame(SDL_Surface* image, SDL_Surface* destSurface, int x, int y, int width, int height, int frame);
void moveBitMap(int& xPosition, int& yPosition, int width, int height, int& xDirection, int& yDirection);
bool ProgramIsRunning();

int main(int argc, char* args[])
{
    if(SDL_Init(SDL_INIT_EVERYTHING) < 0)
    {
        printf("Failed to initialize SDL!\n");
        return 0;
    }

    Backbuffer = SDL_SetVideoMode(ScreenWidth, ScreenHeight, 32, SDL_SWSURFACE);

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

         xPosition = SpritePos.x;
         yPosition = SpritePos.y;

        moveBitMap(xPosition,  yPosition, BMWidth, BMHeight, dirX, dirY);                     //move the bitmap
        SpritePos.x = xPosition;       //update x with new position
        SpritePos.y = yPosition;       //update y with new position
        SDL_BlitSurface(Background, NULL, Backbuffer, NULL);           //Blit background to buffer
        DrawImageFrame(SpriteImage, Backbuffer, 385, SpritePos.y, BMWidth, BMHeight, SpriteFrame);
        SDL_Delay(10);                       //wait 5 seconds
        SDL_Flip(Backbuffer);          //flip the buffer and blit to game screen
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

void moveBitMap(int& xPosition, int& yPosition, int width, int height, int& xDirection, int& yDirection)
{
    // Variables that are local to moveBitmap
        int x;
        int y;
        int dirX;
        int dirY;

    // Assign the arguments in the parameter list to variables local to this function
        x = xPosition;
        y = yPosition;
        dirX = xDirection;
        dirY = yDirection;

        // Calculate new x position with x direction value
        x = x + dirX;

        // left/right
        // Determine if the bitmap is going beyond the right border
        if(xPosition > (ScreenWidth-BMWidth))
        {
            // may have to sub 1-4 pixel
            x = ScreenWidth-BMWidth;
            dirX = -1;
        }

        // Determine if the bitmap is going beyond the left border
        if(xPosition <= (ScreenWidth-BMWidth))
        {
            x = 5;
            dirX = 1;
        }

        // Calculate a new y position with y direction value
        y = y + dirY;

        // up/down
        // Determine if the Bitmap is going below the bottom border
        if(yPosition > (ScreenHeight - BMHeight))
        {
           // may have to sub 1-4 pixels
           y = ScreenHeight - BMHeight;
           dirY = -1;
        }

        // Determine if the bitmap is going beyond the top border
        if(yPosition <= 0)
        {
            y = 5;
            dirY = 1;
        }

        // Now update the x and y positions and directions to the new positions and directions
        xPosition  = x;
        yPosition = y;
        xDirection = dirX;
        yDirection = dirY;
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
