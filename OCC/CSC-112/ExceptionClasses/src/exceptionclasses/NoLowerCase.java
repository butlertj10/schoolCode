package exceptionclasses;

/**
 *
 * @see Exception
 * @author Trev
 */
public class NoLowerCase extends Exception
{
    private String msg;
    
    NoLowerCase(String msg) 
    {
        this.msg = msg;
    }
    
    NoLowerCase()
    {
        msg = "Password does not contain a lowercase letter, please try again.";
    }
    
    @Override
    public String getMessage()
    {
        return msg;
    }
}