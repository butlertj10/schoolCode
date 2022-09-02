/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractex;

/**
 *
 * @author t.j.butler2
 */
public class AbstractEx 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Car myCar = new Car();
        //Vehicles myVehicles = new Vehicles();
        
        System.out.println(myCar.fuelConsumption());
        //System.out.println(myVehicles.fuelConsumption());
    }
    
}
