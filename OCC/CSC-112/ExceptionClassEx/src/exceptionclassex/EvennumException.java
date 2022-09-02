package exceptionclassex;

/**
 *
 * @author t.j.butler2
 */
public class EvennumException extends Exception 
{
    private String msg;
    
    EvennumException(String msg)
    {
        this.msg = msg;
    }
    
    EvennumException()
    {
        msg = "Input must be an even integer, please try again.";
    }
    
    @Override
    public String getMessage()
    {
        return msg;
    }
}
