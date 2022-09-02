package electronics;

/**
 * Represents characteristics of Home Appliances
 * 
 * @version 1.0
 * @author Trev
 * @see Electronics 
 */
public abstract class HomeAppliance extends Electronics  
{
    protected String room;

    /**
    * Assigns values
    *
    * @param eManufacturer
    * @param ePrice
    * @param eWeight
    * @param room
    */
    public HomeAppliance(String eManufacturer, double ePrice, double eWeight, 
            String room) 
    {
        super(eManufacturer, ePrice, eWeight);
    }
    
    /**
    * Enforces every subclass to have method room()
    */
    public abstract String room();
}
