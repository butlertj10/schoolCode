package electronics;

/**
 * Creates framework for WallClock description to be developed
 * 
 * @version 1.0
 * @author Trev
 * @see Clock
 */
public class WallClock extends Clock
{

    /**
     * Sets parameters to class values
     * 
     * @param eManufacturer
     * @param ePrice
     * @param eWeight
     * @param time
     * @param room 
     */
    public WallClock(String eManufacturer, double ePrice, double eWeight, String
            time, String room) 
    {
        super(eManufacturer, ePrice, eWeight, time, room);
        
        this.manufacturer = eManufacturer;
        this.price = ePrice;
        this.weight = eWeight;
        this.currentTime = time;
        this.room = room;
    }
    
    /**
    * Sets parameter time to currentTime 
    */
    public void setTime(String time)
    {
        this.currentTime = time;
    }
    
    /**
     * Creates framework/description of WallClock
     * 
     * @return description of WallClock
     */
    @Override
    public String toString() 
    {
        return String.format("Wall Clock\nThe current time is: %1$s\nManufactured"
                + " by %2$s\nThe Price is $%3$.2f\nWeight of "
                + "%4$.1f lbs\nWall Clock is hanging in %5$s\n",
                currentTime, manufacturer, price, weight, room);
    }
}
