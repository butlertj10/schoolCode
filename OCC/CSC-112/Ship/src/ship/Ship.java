package ship;

/**
 * @see ShipDetails
 * @author Trev
 */
public abstract class Ship implements ShipDetails
{
    protected String name;
    protected int year; 
    
    /**
     * Base Constructor
     */
    public Ship()
    {
    }
    
    /**
     * Sets class variables
     * 
     * @param name
     * @param year 
     */
    public Ship(String name, int year)
    {
        this.name = name;
        this.year = year;
    }

    /**
     * Gets name
     * 
     * @return name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Sets name
     * 
     * @param name 
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * Gets year
     * 
     * @return year
     */
    public int getYear() 
    {
        return year;
    }

    /**
     * Sets year
     * 
     * @param year 
     */
    public void setYear(int year) 
    {
        this.year = year;
    } 
}
