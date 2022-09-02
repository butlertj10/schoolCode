package electronics;

/**
 * Creates framework for alarmClock description to be developed
 * 
 * @verison 1.0
 * @author Trev
 * @see Clock
 */
public class AlarmClock extends Clock
{
    protected String alarmTime;
           
    /**
     * Sets parameters to class values
     * 
     * @param eManufacturer
     * @param ePrice
     * @param eWeight
     * @param time
     * @param aTime
     * @param room 
     */
    public AlarmClock(String eManufacturer, double ePrice, double eWeight, String
            time, String aTime, String room) 
    {
        super(eManufacturer, ePrice, eWeight, time, room);
        
        this.manufacturer = eManufacturer;
        this.price = ePrice;
        this.weight = eWeight;
        this.currentTime = time;
        this.alarmTime = aTime;
        this.room = room;
        
    }
    
    /**
     * Sets parameter aTime to alarmTime
     * 
     * @param aTime 
     */
    public void setAlarm(String aTime)
    {
        this.alarmTime = aTime;
    }
    
    /**
     * Sets parameter time to currentTime
     * 
     * @param time 
     */
    public void setTime(String time)
    {
        this.currentTime = time;
    }

    /**
     * Creates framework/description of AlarmClock
     * 
     * @return description of AlarmClock
     */
    @Override
    public String toString() 
    {
        return String.format("Alarm Clock\nThe current time is: %1$s\nAlarm set"
                + " for %2$s\nManufactured by %3$s\nThe Price is $%4$.2f\nWeight"
                + " of %5$.1f lbs\n",
                currentTime, alarmTime, manufacturer, price, weight);
    } 
}
