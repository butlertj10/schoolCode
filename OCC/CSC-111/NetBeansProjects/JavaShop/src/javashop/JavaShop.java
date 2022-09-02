
package javashop;

/**
 *
 * @author Trev
 */
public class JavaShop 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Coffee darkRoast = new Coffee();
        Coffee lightRoast = new Coffee(10, 0, 8.99, 16, "Light Roast");
        
        System.out.println(darkRoast);
        System.out.println(lightRoast);
    }
    
}
