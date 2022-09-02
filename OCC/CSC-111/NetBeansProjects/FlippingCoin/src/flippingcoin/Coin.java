package flippingcoin;

import java.util.Random;

/**
 *
 * @author Trev
 */
public class Coin 
{
    private final int HEADS = 1;
    private final int TAILS= 2;
    private int face;
    private Random gen;
    // public String faceName;
    
    public Coin()
    {
        gen = new Random();
        Flip();
       // System.out.println("Coin Being Created");
    }
    
    public void Flip()
    {  
        face = gen.nextInt(2)+1;
    }
    
    public boolean isHead()
    {
        boolean result;
        
        if(face == HEADS)
            result = true;
        else
            result = false;
        
        return result;
    }
    
    public String toString()
    {
        String msg = "";
        
          if(face == HEADS)
            msg = "The Coin is Heads";
          else if(face == TAILS)
            msg = "The Coin is Tails";
        
        return msg;
    }
}
