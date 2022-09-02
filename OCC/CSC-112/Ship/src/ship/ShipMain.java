package ship;

/**
 *
 * @author Trev
 */
public class ShipMain
{
    /** 
     * 
     * @param args 
     */
    public static void main(String[] args) 
    {
        ShipDetails cruise1 = new CruiseShip(3000, "Blue Whale", 1990);
        ShipDetails cruise2 = new CruiseShip(3300, "White Whale", 2000);
        ShipDetails cargo1 = new CargoShip(20000, "Pot Belly 1", 1990);
        ShipDetails cargo2 = new CargoShip(23000, "Pot Belly 2", 1865);

        cruise1.DisplayShipDetails();
        cruise2.DisplayShipDetails();
        cargo1.DisplayShipDetails();
        cargo2.DisplayShipDetails();

        if (cruise1.isOlder(cruise2)) 
        {
            System.out.println(((CruiseShip) cruise1).getName() + " is older");
        } 
        else 
        {
            System.out.println(((CruiseShip) cruise2).getName() + " is older");
        }

        if (cargo1.isOlder(cargo2)) 
        {
            System.out.println(((CargoShip) cargo1).getName() + " is older");
        } 
        else 
        {
            System.out.println(((CargoShip) cargo2).getName() + " is older");
        }
    }
}
