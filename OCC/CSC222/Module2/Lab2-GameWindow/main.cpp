#include <SDL/SDL.h>
SDL_Surface* background = NULL;
SDL_Surface* sprite1 = NULL;
SDL_Surface* sprite2 = NULL;
SDL_Surface* backbuffer = NULL;
bool ProgramIsRunning();
bool LoadImages();
void FreeImages();

int main(int argc, char* args[])
{
    if(SDL_Init(SDL_INIT_EVERYTHING) < 0)
    {
        printf("SDL failed to initialize!\n");
        SDL_Quit();
        return 0;
    }
    // Sets screen size and title
    backbuffer = SDL_SetVideoMode(1500, 1000, 32, SDL_SWSURFACE);
    SDL_WM_SetCaption("Trevor Butler", NULL);

    // Creates output if images do not load
    if(!LoadImages())
    {
        printf("Images failed to load!\n");
        FreeImages();
        SDL_Quit();
        return 0;
    }
    SDL_BlitSurface(background, NULL, backbuffer, NULL ); //blit the background to the buffer

    // Game loop which runs until program closes
    while(ProgramIsRunning())
    {
        // Adds first sprite to screen while defining coordinates
        SDL_Rect spritePos;           //define a structure (SDL_Rect) that contains data for a rectangle (spritePos).
        spritePos.x = rand()%800;     //select an x coordinate between 0 and 800
        spritePos.y = rand()%600;     //select a y coordinate between 0 and 600
        SDL_BlitSurface(sprite1, NULL, backbuffer, &spritePos);  //blit the rectangle to the buffer
        SDL_Flip(backbuffer);     //flip the buffer and draw to the game screen
        SDL_Delay(100);           //wait 1/10th of a second before drawing the next sprite to a random location

        // Adds second sprite to screen with different set of coordinates
        SDL_Rect sprite2Pos;           //define a structure (SDL_Rect) that contains data for a rectangle (spritePos).
        sprite2Pos.x = rand()%700;     //select an x coordinate between 0 and 700
        sprite2Pos.y = rand()%500;     //select a y coordinate between 0 and 500
        SDL_BlitSurface(sprite2, NULL, backbuffer, &sprite2Pos);  //blit the rectangle to the buffer
        SDL_Flip(backbuffer);     //flip the buffer and draw to the game screen
        SDL_Delay(100);           //wait 1/10th of a second before drawing the next sprite to a random location
    }
    SDL_Quit();
    return 1;
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

// Loads images
bool LoadImages()
{
    background = SDL_LoadBMP("graphics/background.bmp");
    if(background == NULL)
        return false;
    sprite1 = SDL_LoadBMP("graphics/sprite1.bmp");
    if(sprite1 == NULL)
        return false;
    sprite2 = SDL_LoadBMP("graphics/sprite2.bmp");
    if(sprite2 == NULL)
        return false;
    return true;
}

// Sets images
void FreeImages()
{
    if(background != NULL)
    {
        SDL_FreeSurface(background);
        background = NULL;
    }
    if(sprite1 != NULL)
    {
        SDL_FreeSurface(sprite1);
        sprite1 = NULL;
    }
        if(sprite2 != NULL)
    {
        SDL_FreeSurface(sprite2);
        sprite2 = NULL;
    }
}
