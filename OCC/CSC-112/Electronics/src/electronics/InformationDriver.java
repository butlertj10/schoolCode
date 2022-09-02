package electronics;

/**
 * Allows item descriptions to be developed with required parameters
 * 
 * @version 1.0
 * @author Trev
 */
public class InformationDriver 
{
     /**
    * Creates/Displays item descriptions 
    * 
    * @param args the command line arguments
    */
    public static void main(String[] args) 
    {
        // Creates/Displays an iPod
        iPod myIpod = new iPod("Apple", 149.99, 4.8, "iPod Touch 5th Generation"
                ,"DOCA 3.7V Li-Polymer Rechargeable Battery", 32);
        System.out.println(myIpod);
        
        // Creates/Displays a Cell Phone 
        CellPhone myCell = new CellPhone("Apple", 999.99, 6.24, "(315) 489-9237"
                , true, "3,174mAh");
        System.out.println(myCell);
        
        // Creates/Displays a Clock
        Clock clock1 = new Clock("Timex", 19.99, 2.5, "11:32 PM","256");
        System.out.println(clock1);
        
        // Creates/Displays a Printer
        Printer printer1 = new Printer("HP", 399.99, 9.8, 120, false, true, 
                "123");
        System.out.println(printer1);
        
        // Creates/Displays a Wall Clock
        WallClock wallClock1 = new WallClock("Sekio", 39.99, 1.2, "3:29 AM", 
                "Kitchen");
        System.out.println(wallClock1);
        
        // Creates/Displays an Alarm Clock
        AlarmClock alarmClock1 = new AlarmClock("Sekio", 15.99, 1.2, "8:42 PM", 
                "6:00 AM", "Kitchen");
        System.out.println(alarmClock1);
    }
}
