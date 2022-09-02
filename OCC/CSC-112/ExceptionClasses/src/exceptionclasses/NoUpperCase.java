package exceptionclasses;

/**
 *
 * @see Exception
 * @author Trev
 */
public class NoUpperCase extends Exception
{
    private String msg;
            
    NoUpperCase(String msg) 
    {
        this.msg = msg;
    }
    
    NoUpperCase()
    {
        msg = "Password does not contain an uppercase letter, please try again.";
    }
    
    @Override
    public String getMessage()
    {
        return msg;
    }
}
