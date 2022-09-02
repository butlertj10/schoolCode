package interpoly;

/**
 *
 * @author t.j.butler2
 */
public class InterPoly 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        BikeInterface bike1 = new RaceBike(3,10);
        BikeInterface bike2 = new OffRoadBike(2,8);
    }
    
}
