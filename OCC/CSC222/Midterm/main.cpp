#include <SDL/SDL.h>
#include <SDL/SDL_mixer.h>
#include <SDL/SDL_ttf.h>

// Constant Variables
const int SCREEN_WIDTH = 800;
const int SCREEN_HEIGHT = 600;
const int PADDLE_WIDTH = 20;
const int PADDLE_HEIGHT = 100;
const int BALL_WIDTH = 20;
const int BALL_HEIGHT = 20;
const int BALL_MAX_SPEED = 10;
const int TARGET_PADDLE_X= PADDLE_WIDTH;
const int PLAYER_PADDLE_X = SCREEN_WIDTH - PADDLE_WIDTH*2;
const int PADDLE_SPEED = 10;
const int FPS = 60;
const int FRAME_DELAY = 1000/FPS;

// Surfaces
SDL_Surface *Backbuffer = NULL;
SDL_Surface *BackgroundImage = NULL;
SDL_Surface *BallImage = NULL;
SDL_Surface *PlayerPaddleImage = NULL;
SDL_Surface *TargetPaddleImage = NULL;
SDL_Surface *GameoverImage = NULL;

// Font
TTF_Font *GameFont = NULL;

// Game Variables
int PlayerScore;
int PlayerLife;
int gameState;

int BallXVel;
int BallYVel;

const int RUNNING = 0;
const int GAMELOSS = 1;
const int GAMEWIN = 2;

// Rect Variables
SDL_Rect PlayerPaddleRect;
SDL_Rect TargetPaddleRect;
SDL_Rect BallRect;

// Function declarations
SDL_Surface* LoadImage(char* fileName);
void DrawImage(SDL_Surface* image, SDL_Surface* destSurface, int x, int y);
void DrawText(SDL_Surface* surface, char* string, int x, int y, TTF_Font* font, Uint8 r, Uint8 g, Uint8 b);
bool ProgramIsRunning();
bool LoadFiles();
void FreeFiles();
bool RectsOverlap(SDL_Rect rect1, SDL_Rect rect2);
bool InitSDL();
void ResetGame();
bool InitGame();
void UpdateGame();
void UpdatePlayer();
void UpdateBall();
void RunGame();
void DrawLost();
void DrawWin();
void DrawGame();
void DrawScreen();
void FreeGame();

int main(int argc, char *argv[])
{
    if(!InitGame())
    {
        FreeGame();   // If InitGame failed, end the program
        return 0;
    }

    while(ProgramIsRunning())
    {
        long int oldTime = SDL_GetTicks();          // See how long it took to update the frame
        SDL_FillRect(Backbuffer, NULL, 0);          // Clear the screen
        RunGame();                                  // Update the game
        DrawGame();                                 // Draw the screen

        int frameTime = SDL_GetTicks() - oldTime;

        if(frameTime < FRAME_DELAY)                 // Don't delay if unnecessary
            SDL_Delay(FRAME_DELAY - frameTime);     // Delay

        SDL_Flip(Backbuffer);                       // Flip the screen
    }

    FreeGame();     // Release SDL and its resources.

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

void DrawText(SDL_Surface* surface, char* string, int x, int y, TTF_Font* font, Uint8 r, Uint8 g, Uint8 b)
{
    SDL_Surface* renderedText = NULL;

    SDL_Color color;

    color.r = r;
    color.g = g;
    color.b = b;

    renderedText = TTF_RenderText_Solid( font, string, color );

    SDL_Rect pos;

    pos.x = x;
    pos.y = y;

    SDL_BlitSurface( renderedText, NULL, surface, &pos );
    SDL_FreeSurface(renderedText);
}

bool ProgramIsRunning()
{
    SDL_Event event;

    bool running = true;

    while(SDL_PollEvent(&event))
    {
        if(event.type == SDL_QUIT)
            running = false;

        if( event.type == SDL_KEYDOWN )
        {
            if(event.key.keysym.sym == SDLK_ESCAPE)
            {
                running = false;
            }
        }
    }

    return running;
}

bool LoadFiles()
{
    //Load images
    BackgroundImage = LoadImage("graphics/background.bmp");
    BallImage = LoadImage("graphics/ball.bmp");
    PlayerPaddleImage = LoadImage("graphics/player.bmp");
    TargetPaddleImage = LoadImage("graphics/enemy.bmp");
    GameoverImage = LoadImage("graphics/gameover.bmp");

    //Error checking images
    if(BackgroundImage == NULL)
        {
            printf("Background did not load.");
            return false;
        }
    if(BallImage == NULL)
        {
            printf("Ball did not load.");
            return false;
        }
    if(PlayerPaddleImage == NULL)
        {
            printf("Player did not load.");
            return false;
        }
    if(TargetPaddleImage == NULL)
        {
            printf("Enemy did not load.");
            return false;
        }
    if(GameoverImage == NULL)
        return false;

    //Load font
    GameFont = TTF_OpenFont("graphics/alfphabet.ttf", 30);

    //Error check font
    if(GameFont == NULL)
        {
            printf("Graphics did not load.");
            return false;
        }

    return true;
}

void FreeFiles()
{
    //Free images
    SDL_FreeSurface(BackgroundImage);
    SDL_FreeSurface(BallImage);
    SDL_FreeSurface(PlayerPaddleImage);
    SDL_FreeSurface(TargetPaddleImage);
    SDL_FreeSurface(GameoverImage);

    //Free font
    TTF_CloseFont(GameFont);
}

bool RectsOverlap(SDL_Rect rect1, SDL_Rect rect2)
{
    if(rect1.x >= rect2.x+rect2.w)
        return false;

    if(rect1.y >= rect2.y+rect2.h)
        return false;

    if(rect2.x >= rect1.x+rect1.w)
        return false;

    if(rect2.y >= rect1.y+rect1.h)
        return false;

    return true;
}

bool InitSDL()
{
    if(SDL_Init(SDL_INIT_EVERYTHING) == -1)
        return false;

    //Init audio subsystem
    if(Mix_OpenAudio( 22050, MIX_DEFAULT_FORMAT, 2, 2048 ) == -1)
    {
        return false;
    }

    //Init TTF subsystem
    if(TTF_Init() == -1)
    {
        return false;
    }

    //Generate screen
    Backbuffer = SDL_SetVideoMode(SCREEN_WIDTH, SCREEN_HEIGHT, 32, SDL_SWSURFACE );

    //Error check Backbuffer
    if(Backbuffer == NULL)
        return false;

    return true;
}

void ResetGame()
{
    // Position the player's paddle
    TargetPaddleRect.y = SCREEN_HEIGHT/2 - PADDLE_HEIGHT/2;
    TargetPaddleRect.w = PADDLE_WIDTH;
    TargetPaddleRect.h = PADDLE_HEIGHT;

    // Position the enemy's paddle
    PlayerPaddleRect.x = PLAYER_PADDLE_X;
    PlayerPaddleRect.y = SCREEN_HEIGHT/2 - PADDLE_HEIGHT/2;
    PlayerPaddleRect.w = PADDLE_WIDTH;
    PlayerPaddleRect.h = PADDLE_HEIGHT;

    // Position the ball
    BallRect.x = SCREEN_WIDTH/3 - BALL_WIDTH/2;
    BallRect.y = SCREEN_HEIGHT/2 - BALL_HEIGHT/2;
    BallRect.w = BALL_WIDTH;
    BallRect.h = BALL_HEIGHT;

    // Make the ball X velocity a random value from 2 to BALL_MAX_SPEED
    BallXVel = rand()%BALL_MAX_SPEED + 2;

    // Make the ball Y velocity a random value from 2 to BALL_MAX_SPEED
    BallYVel = rand()%BALL_MAX_SPEED + 2;

    // Give it a 50% probability of going towards the player
    if(rand()%2 == 0)
        BallXVel *= -1;
}

bool InitGame()
{
    // Initialize SDL
    if(!InitSDL())
        return false;

    // Load Files
    if(!LoadFiles())
        return false;

    // Initialize game variables
    gameState = RUNNING;

    //Set the title
    SDL_WM_SetCaption("Single Player Pong!",NULL);

    // Sets player score to 0 and lives to 3
    PlayerScore = 0;
    PlayerLife = 3;

    // This will also set the initial variables
    ResetGame();

    return true;
}

void UpdatePlayer()
{
    Uint8 *keys = SDL_GetKeyState(NULL);

    // Moves paddle when the up/down key is pressed
    if(keys[SDLK_UP])
        PlayerPaddleRect.y -= PADDLE_SPEED;

    if(keys[SDLK_DOWN])
        PlayerPaddleRect.y += PADDLE_SPEED;

    // Keeps paddle in game screen
    if(PlayerPaddleRect.y < 0)
        PlayerPaddleRect.y = 0;

    if(PlayerPaddleRect.y > SCREEN_HEIGHT-PlayerPaddleRect.h)
        PlayerPaddleRect.y = SCREEN_HEIGHT-PlayerPaddleRect.h;
}

void UpdateGame()
{
    UpdatePlayer();
    UpdateBall();

    // Checks if player hits target paddle
    if(RectsOverlap(TargetPaddleRect, BallRect))
        PlayerScore++;

    // If player's lives are less than or equal to zero game is a loss
    if(PlayerLife <= 0)
        gameState = GAMELOSS;

    // If players score is equal to three game is a win
    if(PlayerScore == 3)
        gameState = GAMEWIN;
}

void DrawLost()
{
    char lostTXT[64];

    // Draws Game Over Image with losing text
    sprintf(lostTXT, "You have no more lives left!", PlayerLife);
    DrawImage(GameoverImage, Backbuffer, 0, 0);
    DrawText(GameoverImage, lostTXT, 80, 500, GameFont, 0, 0, 0);
}

void DrawWin()
{
    char winTXT[64];

    // Draws Game Over Image with winning text
    sprintf(winTXT, "You have reached the winning score of 3!", PlayerLife);
    DrawImage(GameoverImage, Backbuffer, 0, 0);
    DrawText(GameoverImage, winTXT, 0, 500, GameFont, 0, 0, 0);
}

void UpdateBall()
{
    BallRect.x += BallXVel;
    BallRect.y += BallYVel;

    // If the ball hits the target, it will bounce
    if(RectsOverlap(BallRect, TargetPaddleRect))
    {
        BallXVel = rand()%BALL_MAX_SPEED + 5;
    }

    // If the ball hits the player, it will bounce
    if(RectsOverlap(BallRect, PlayerPaddleRect))
    {
        BallXVel = (rand()%BALL_MAX_SPEED + 5) * -1;
    }

    // Bounces ball off top edge
    if(BallRect.y < 0)
    {
        BallRect.y = 0;
        BallYVel = rand()%BALL_MAX_SPEED + 1;
    }

    // Bounces ball off bottom edge
    if(BallRect.y > SCREEN_HEIGHT - BallRect.h)
    {
        BallRect.y = SCREEN_HEIGHT - BallRect.h;
        BallYVel = (rand()%BALL_MAX_SPEED + 1)* -1;
    }

    // Bounces ball off right edge
    if(BallRect.x < 0)
    {
        BallRect.x = 0;
        BallXVel = (rand()%BALL_MAX_SPEED + 1);
    }

    // If player misses, reset game and remove life
    if(BallRect.x > SCREEN_WIDTH)
    {
        PlayerLife--;
        ResetGame();
    }
}

void RunGame()
{
    switch(gameState)
    {
    case RUNNING:
        UpdateGame();   // Updates Game
        break;
    case GAMELOSS:      // Displays Game Lost screen
        DrawLost();
        break;
    case GAMEWIN:       // Displays Game Win screen
        DrawWin();
        break;
    default:
        break;
    }
}

void DrawGame()
{
    // Draws images to screen
    DrawImage(BackgroundImage, Backbuffer, 0, 0);
    DrawImage(BallImage, Backbuffer, BallRect.x, BallRect.y);
    DrawImage(TargetPaddleImage, Backbuffer, TargetPaddleRect.x, TargetPaddleRect.y);
    DrawImage(PlayerPaddleImage, Backbuffer, PlayerPaddleRect.x, PlayerPaddleRect.y);

    // Text variables
 	char playerHUD[64];
	char scoreHUD[64];
	char exitTXT[64];

	// Initializes text to be displayed
	sprintf(playerHUD, "Score: %d", PlayerScore);
	sprintf(scoreHUD, "Lives Left: %d", PlayerLife);
	sprintf(exitTXT, "Press ESC to exit");


	// Draws text to screen
	DrawText(Backbuffer, playerHUD, 0, 1, GameFont, 255, 255, 255);
	DrawText(Backbuffer, scoreHUD, 0, 30, GameFont, 255, 255, 255);
	DrawText(Backbuffer, exitTXT, 0, 570, GameFont, 255, 255, 255);
}

void DrawScreen()
{
    switch(gameState)
    {
    case RUNNING:
        RunGame();  // Run game
        break;
    case GAMELOSS:
        DrawLost(); // Draws lost game screen
        break;
    case GAMEWIN:
        DrawWin();  // Draws win game screen
        break;
    default:
        break;
    }
}

void FreeGame()
{
    FreeFiles();        // Releases loaded files
    TTF_Quit();         // Closes font
    SDL_Quit();         // Closes SDL
}

