package electronics;

/**
 * Creates framework for Printer description to be developed
 * 
 * @version 1.0
 * @author Trev
 * @see HomeAppliance
 */
public class Printer extends HomeAppliance
{
    protected int dotsPerInch;
    protected boolean paperLoaded;
    protected boolean inkLoaded;
    private String paperStatus;
    private String inkStatus;

    /**
     * Sets parameters to class values and determines if printer has paper/ink
     * 
     * @param eManufacturer
     * @param ePrice
     * @param eWeight
     * @param dpi
     * @param paper
     * @param ink
     * @param room 
     */
    public Printer(String eManufacturer, double ePrice, double eWeight, int dpi,
            boolean paper, boolean ink, String room) 
    {
        super(eManufacturer, ePrice, eWeight, room);
        
        // Sets Values
        this.manufacturer = eManufacturer;
        this.price = ePrice;
        this.weight = eWeight;
        this.dotsPerInch = dpi;
        this.paperLoaded = paper;
        this.inkLoaded = ink;
        this.room = room;
        
        // Determines display of ink status
        if(inkLoaded == true)
        {
            inkStatus = "has ink";
        }
        else
        {
            inkStatus = "doesn't have ink";
        }
        
        // Determines display of paper status
        if(paperLoaded == true)
        {
            paperStatus = "has paper";
        }
        else
        {
            paperStatus = "doesn't have paper";
        }
    }
    
    /**
     * Sets variable room to method room()
     * 
     * @return this.room
     */
    public String room()
    {
        return this.room;
    }
    
    /**
     * Contains printer status
     * 
     * @return true
     */
    public boolean printerStatus()
    {
        return true;
    }
    
    /**
     * Sets paperLoaded variable to parameter status
     * 
     * @param status 
     */
    public void loadPaper(boolean status)
    {
        paperLoaded = status;
    }
    
    /**
     * Sets inkLoaded variable to parameter status
     * 
     * @param status 
     */
    public void loadInk(boolean status)
    {
        inkLoaded = status;
    }

    /**
     * Creates framework/description of clock
     * 
     * @return description of Printer 
     */
    @Override
    public String toString() 
    {
        return  String.format("Printer\nPrinter prints %1$d dots per inch\n"
                + "Printer %2$s\nPrinter %3$s\nManufactured by "
                + "%4$s\nThe price is %5$.2f\nWeight of %6$.1f lbs\nThe printer"
                + " is located room %7$s\n", 
                dotsPerInch, paperStatus, inkStatus ,manufacturer, price, weight
                , room);
    }
}
