package videogames;

public class GameCollection 
{
    // Declare Variables
    public final int COLLECT_SIZE = 10;
    public Game collection[];
    public int numGames;

    /*****************************
    *  public GameCollection()
    * 
    *  Set numGames equal to 0
    *  Create an array of games
    *****************************/
    public GameCollection()
    {
        // Set numGames equal to 0
        numGames = 0;
        
        // Create array of games
        collection = new Game[COLLECT_SIZE];
    }

    /************************************************************
    *  public void addGame(String title, String rating, String type)
    *  
    *  IF(numGames is equal to length of Collection array)
    *       Call increaseSize()
    *   END IF
    *   Create temporary array
    *   Set Collection at numGames equal to temporary array
    *   Add one to numGames
    ************************************************************/
    public void addGame(String title, String rating, String type)
    {
        // IF(numGames is equal to length of Collection array)
        if(numGames == collection.length)
        {
            // Call increaseSize()
            increaseSize();
        }

        // Create temporary array
        Game temp = new Game(title, rating, type);
        
        // Set Collection at numGames equal to temporary array
        collection[numGames] = temp;
        
        // Add one to numGames
        numGames++;
    }

    /************************************************************
    *  public void addGame(Game temp)
    * 
    *  IF(numGames is equal to length of Collection array)
    *       Call increaseSize()
    *   END IF
    *   Set Collection at numGames equal to temporary array
    *   Add one to numGames
    ************************************************************/
    public void addGame(Game temp)
    {
        // IF(numGames is equal to length of Collection array)
        if(numGames == collection.length)
        {
            // Call increaseSize()
            increaseSize();
        }
        
        // Set Collection at numGames equal to temporary array
        collection[numGames] = temp;
        
        // Add one to numGames
        numGames++;
    }

    /*******************************************************
    *   public String toString()
    * 
    *   Create String msg and make it empty
    *   Catenate msg with title of "Games in Collection"
    *   FOR(All values in Collection Array)
    *       Catenate msg with video game description
    *   END FOR
    *   Catenate msg with number of games in collection
    *   Return msg
    ******************************************************/
    public String toString()
    {
        // Create String msg and make it empty
        String msg = "";

        // Catenate msg with title of "Games in Collection"
        msg += "----- Games in Collection -----\n";
        
        // FOR(All values in Collection Array)
        for(int index = 0; index < numGames; index++)
        {
            // Catenate msg with video game description
            msg += collection[index].toString();
            msg += "\n";
        }

        // Catenate msg with number of games in collection
        msg += "Number of Games in Collection: " + numGames + "\n";

        // return msg
        return msg;
    }

    /*****************************************************************
    *   Create temporary Game array
    *   FOR(Each value of the length of collection)
    *       at the index of temporary array, add to Collection array
    *   END FOR
    *   Set Collection array equal to temporary array
    ******************************************************************/
    private void increaseSize()
    {
        // Create temporary Game array
        Game temp [] = new Game[collection.length * 2];

        // FOR(Each value of the length of collection)
        for(int index = 0; index < collection.length; index++)
        {
            // at the index of temporary array, add to Collection array
            temp[index] = collection[index];
        }

        // Set Collection array equal to temporary array
        collection = temp;
    }
}

