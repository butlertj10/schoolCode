package javadocs;

/**
 * This is my Coffee Class
 * 
 * @author Trev
 */
public class Coffee 
{
    private String name;
    private double weight;
    private int inStock;
    
    public Coffee()
    {
        
    }
    
    public Coffee(String n)
    {
        this.name = n;
    }

    public Coffee(String name, double weight, int inStock) 
    {
        this.name = name;
        this.weight = weight;
        this.inStock = inStock;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public double getWeight() 
    {
        return weight;
    }

    public void setWeight(double weight) 
    {
        this.weight = weight;
    }

    public int getInStock() 
    {
        return inStock;
    }

    public void setInStock(int inStock) 
    {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Coffee{" + "name = " + name + ", weight = " + weight + ", inStock = " + inStock + '}';
    }
    
    
}