package exceptionclasses;

/**
 * @see Exception
 * @author Trev
 */
public class NoDigit extends Exception
{   
    private String msg;
    
    NoDigit(String msg) 
    {
        this.msg = msg;
    }
    
    NoDigit()
    {
        msg = "Password does not contain a number, please try again,"
                + " please try again.";
    }
    
    @Override
    public String getMessage()
    {
        return msg;
    }
}
