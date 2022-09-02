package execptionexample;

/**
 *
 * @author t.j.butler2
 */
public class ExecptionExample 
{
    public static void main(String[] args) 
    {
        int num, dem;
        
        
        num = 3;
        dem = 0;
        
        try
        {
            Division(num, dem);
        }
        catch(ArithmeticException ex)
        {
            System.out.println("There was an exception error");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        System.out.println("Program has ended");
    }
    
    public static void Division(int num, int dem)
    {
        double result = 0.0;
        if(dem == 0)
            throw new ArithmeticException("Numerator cannot be divided by zero");
            result = num/dem;
            System.out.println("The result is: " + result);
    }
}
