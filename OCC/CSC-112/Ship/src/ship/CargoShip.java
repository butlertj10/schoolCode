package ship;

/**
 * @see Ship
 * @author Trev
 */
public class CargoShip extends Ship
{
    protected int capacity;
    
    /**
     * Base constructor
     */
    public CargoShip()
    { 
    }

    /**
     * Sets class variables
     * 
     * @param capacity
     * @param name
     * @param year 
     */
    public CargoShip(int capacity, String name, int year) 
    {
        this.capacity = capacity;
        this.name = name;
        this.year = year;
    }

    /**
     * Gets the capacity 
     * 
     * @return capacity
     */
    public int getCapacity() 
    {
        return capacity;
    }
    
    /**
     * Sets capacity
     * 
     * @param capacity 
     */
    public void setCapacity(int capacity) 
    {
        this.capacity = capacity;
    }

    /**
     * Displays ship details
     */
    public void DisplayShipDetails() 
    {
        System.out.println(String.format("--Cargo Ship--\nName: %1$s\nYear: %2$s"
        + "\nCapacity: %3$s tons\n",
        name, year, capacity));
    }

    /**
     * Determines which ship is older
     * 
     * @param obj
     * @return result
     */
    @Override
    public boolean isOlder(ShipDetails obj) 
    {
        boolean result = false;
        CargoShip temp = (CargoShip)obj;
        
        if(name.compareTo(temp.name) < 0)
            result = false;
        else if(name.compareTo(temp.name) > 0)
            result = true;
        return result;
    }
}
