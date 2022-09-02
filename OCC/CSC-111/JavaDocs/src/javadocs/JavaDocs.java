package javadocs;

/**
 *
 * @author Trev
 */
public class JavaDocs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Coffee x = new Coffee();
        Coffee y = new Coffee("Dark Roast");
        
        System.out.println(y);
        System.out.println(x);
        
        DoSomething(4, 5.6);
    }
    
    /**
     * Add description of method
     * @param Value integer value used for ------
     * @param secondValue double used for ......
     * 
     * @return Returns some value to you.
    */ 
    public static int DoSomething(int value, double secondValue)
    {
        return 0;
    }
}

