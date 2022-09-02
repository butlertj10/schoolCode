package electronics;

/**
 * Creates framework for Clock description to be developed
 *
 * @version 1.0 
 * @author Trev
 * @see homeAppliance
 */
public class Clock extends HomeAppliance
{
    protected String currentTime;

    /**
     * Sets values from parameters to class values
     *
     * @see HomeAppliance
     * @param eManufacturer
     * @param ePrice
     * @param eWeight
     * @param time
     * @param room
     */
    public Clock(String eManufacturer, double ePrice, double eWeight, String time,
        String room) 
    {
        super(eManufacturer, ePrice, eWeight, room);
        
        // Sets Values
        this.manufacturer = eManufacturer;
        this.price = ePrice;
        this.weight = eWeight;
        this.currentTime = time;
        this.room = room;
    }
    
    /**
     * Gets the time
     */
    public String getTime()
    {
        return this.currentTime;
    }
    
    /**
     * Sets the time
     */
    public void setTime(String time)
    {
        currentTime = time;
    }
    
    /**
     * Sets room method to class' room variable
     * 
     * @return this.room
     */
    public String room()
    {
        return this.room;
    }

    /**
     * Creates framework/description of Clock
     * 
     * @return Clock Description
     */
    @Override
    public String toString() 
    {
        return String.format("Clock\nClock is in room %5$s\nThe current time is:"
                + " %1$s\nMaufactured by %2$s\nThe Price is $%3$.2f\nWeight of "
                + "%4$.2f lbs\n",
                currentTime, manufacturer, price, weight, room);
    }
}
