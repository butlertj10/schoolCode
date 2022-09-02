package exceptionclasses;

/**
 *
 * @see Exception
 * @author Trev
 */
public class PasswordTooShort extends Exception
{
    private String msg;
      
    PasswordTooShort(String msg) 
    {
        this.msg = msg;
    }
    
    PasswordTooShort()
    {
        msg = "Password is not at least 8 characters , please try again.";
    }
    
    @Override
    public String getMessage()
    {
        return msg;
    }
}
