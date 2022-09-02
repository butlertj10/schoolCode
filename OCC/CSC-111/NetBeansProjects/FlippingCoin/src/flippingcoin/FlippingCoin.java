package flippingcoin;

/**
 *
 * @author Trev
 */
public class FlippingCoin 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // All Declarations
        Coin myCoin = new Coin();
        Coin myCoin2 = new Coin();
        
        int counter = 0;
        int headsCounter = 0;
        int tailsCounter = 0;
        int headsCounter2 = 0;
        int tailsCounter2 = 0;
        
        // Flipping Statement
        for(counter = 0; counter < 1000; counter++)
        {
            myCoin.Flip();
            
            if(myCoin.isHead())
                headsCounter++;
            else
                tailsCounter++;
            
            myCoin2.Flip(); 
            if(myCoin2.isHead())
                headsCounter2++;
            else
                tailsCounter2++;
        }
        
            System.out.println("Heads: " + headsCounter++);
            System.out.println("Tails: " + tailsCounter++);
            
            System.out.println("\nHeads(2): " + headsCounter2++);
            System.out.println("Tails(2): " + tailsCounter2++);
        
        // System.out.println(myCoin);
    }
    
}
