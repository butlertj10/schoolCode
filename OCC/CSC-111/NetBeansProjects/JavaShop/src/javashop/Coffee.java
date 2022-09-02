package javashop;

/**
 *
 * @author Trev
 */
public class Coffee 
{    
    private int bagsInStock;
    private int bagsSold;
    private double price;
    private double weight;
    private String name;
    
    public Coffee()
    {
        bagsInStock = 0;
        bagsSold = 0;
        price = 0.0;
        weight = 0.0;
        name = "Nameless";
    }
    
    public Coffee(int bIS, int bS, double p, double w, String n)
    {
        bagsInStock = bIS;
        bagsSold = bS;
        price = p;
        weight = w;
        name = n;
    }
    
    public int Order(int bags)
    {
        int numOfBags = 0;
        
        return numOfBags; 
    }
    
    public String toString()
    {
        String msg = "Coffee: \n";
        msg += "Bags in Stock = " + bagsInStock + "\n";
        msg += "Bags Sold = " + bagsSold + "\n";
        msg += "Price = $" + price + "\n";
        msg += "Weight = " + weight + " oz." + "\n";
        msg += "Name = " + name + "\n";

        return msg;
    }

}
