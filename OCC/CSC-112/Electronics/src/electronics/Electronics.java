package electronics;

/**
 * Creates pieces subclasses require
 * 
 * @version 1.0
 * @author Trev
 */
public abstract class Electronics 
{
    protected String manufacturer;
    protected double price;
    protected double weight;
    
   /**
    * Creates values for subclasses
    *
    * @param eManufacturer
    * @param ePrice
    * @param eWeight
    */
    public Electronics(String eManufacturer, double ePrice, double eWeight)
    {
        this.manufacturer = eManufacturer;
        this.price = ePrice;
        this.weight = eWeight;
    }

    /**
     * @return empty string 
     */
    @Override
    public String toString() 
    {
        return "";
    }
}
