package ship;

/**
 * @see Ship
 * @author Trev
 */
public class CruiseShip extends Ship
{
    protected int maxPassengers;
    
    /**
     * Base constructor 
     */
    public CruiseShip()
    {
    }

    /**
     * Sets class variables
     * 
     * @param maxPassengers
     * @param name
     * @param year 
     */
    public CruiseShip(int maxPassengers, String name, int year) 
    {
        this.maxPassengers = maxPassengers;
        this.name = name;
        this.year = year;
    } 
    
    /**
     * Gets maxPassengers
     * 
     * @return maxPassengers
     */
    public int getMaxPassengers() 
    {
        return maxPassengers;
    }

    /**
     * Sets maxPassengers
     * 
     * @param maxPassengers 
     */
    public void setMaxPassengers(int maxPassengers) 
    {
        this.maxPassengers = maxPassengers;
    }
    
    /**
     * Displays ship details
     */
    public void DisplayShipDetails() 
    {
        System.out.println(String.format("--Cruise Ship--\nName: %1$s\nYear: %2$s"
        + "\nMaximum Passengers: %3$s Passengers\n",
        name, year, maxPassengers));
    }

    /**
     * Determines which ship is older
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean isOlder(ShipDetails obj) 
    {
        boolean result = false;
        CruiseShip temp = (CruiseShip)obj;
        
        if(name.compareTo(temp.name) < 0)
            result = true;
        else if(name.compareTo(temp.name) > 0)
            result = false;
        return result;    
    }
}
