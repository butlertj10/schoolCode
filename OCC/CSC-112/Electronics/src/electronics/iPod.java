package electronics;

/**
 * Creates framework for iPod description to be developed
 *
 * @version 1.0
 * @author Trev
 * @see PortableElectronics
 */
public class iPod extends PortableElectronics
{
    protected int capacity;
    protected String modelType;

    
   /**
    * Sets values from parameter to class values
    * 
    * @see PortableElectronics
    * @param eManufacturer
    * @param ePrice
    * @param eWeight
    * @param Modeltype
    * @param batteryType
    * @param capacity 
    */
    public iPod(String eManufacturer, double ePrice, double eWeight, String 
            Modeltype, String batteryType, int capacity) 
    {
        super(eManufacturer, ePrice, eWeight, Modeltype);
        
        // Sets Values
        this.manufacturer = eManufacturer;
        this.price = ePrice;
        this.weight = eWeight;
        this.modelType = Modeltype;
        this.capacity = capacity;
        this.batteryType = batteryType;
    }

    /**
    * Assigns batteryType to method
    * 
    * @return this.batteryType
    */
    public String batteryType()
    {
        return this.batteryType;
    }
    
    /**
    * Sets capacity value to method
    *
    * @param capacity
    */
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }
    
    /**
    * Sets modelType to method setModelType
    *
    * @param Type
    */
    public void setModelType(String Type)
    {
        this.modelType = Type;
    }
    
    /**
    * Method returns capacity
    * 
    * @return capacity
    */
    public int getCapacity() 
    {
        return capacity;
    }

    /**
    * Sets modelType to Method getModelType
    * 
    * @return modelType
    */
    public String getModelType() 
    {
        return modelType;
    }
    
    
    /**
    * Displays structure for description
    * 
    * @return iPod description
    */
    @Override
    public String toString() 
    {
        return String.format("iPod\nModel: %1$s with a capacity of %2$s gb\n"
                + "Manufactured by %3$s\nThe price of $%4$.2f\nWeight of "
                + "%5$.2f oz.\n", 
                modelType, capacity, manufacturer, price, weight);
    } 
}
