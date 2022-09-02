package electronics;

/**
 * Creates pieces subclasses require
 * 
 * @version 1.0
 * @author Trev
 * @see Electronics
 */
public abstract class PortableElectronics extends Electronics 
{
    protected String batteryType;

    /**
     * Creates values for subclasses 
     * 
     * @param eManufacturer
     * @param ePrice
     * @param eWeight
     * @param type 
     */
    public PortableElectronics(String eManufacturer, double ePrice,
            double eWeight, String type) 
    {
        super(eManufacturer, ePrice, eWeight);
    }

    /**
     * Required method via superclass
     * 
     * @return batteryType
     */
    public abstract String batteryType();
    
    /**
     * @return empty string 
     */
    @Override
    public String toString() 
    {
        return "";
    }
}
