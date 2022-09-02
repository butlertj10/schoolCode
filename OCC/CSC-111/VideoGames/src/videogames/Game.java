package videogames;

public class Game 
{
    // Declare Variables
    private String title;
    private String rating;
    private String type;
    
    /*******************************************
    *   Set title, rating, and type equal to N/A
    ********************************************/
    public Game()
    {
        // Set title, rating, and type equal to N/A
        title = rating = type = "N/A";
    }
    
    /******************************
    *  Set Variables to parameters 
    ******************************/
    public Game(String gameTitle, String ageRating, String gameType)
    {
        // Set Variables to parameters
        title = gameTitle;
        rating = ageRating;
        type = gameType;
    }
    
    /*******************************************************
    *   Declare msg and make it empty
    *   Catenate msg to display the properties of the game
    *   Return msg
    *******************************************************/
    public String toString()
    {
        // Declare msg and make it empty
        String msg = "";
        
        // Catenate msg to display the properties of the game
        msg += "Game Title: " + title + "\n";
        msg += "Age Rating: " + rating + "\n";
        msg += "Type of Game: " + type + "\n";
        
        // Return msg
        return msg;
    }
}
