/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpoly;

/**
 *
 * @author t.j.butler2
 */
public class OffRoadBike extends Bike
{

    public OffRoadBike(int gear, int speed) 
    {
        super(gear, speed);
    }

    @Override
    public String toString() 
    {
        return "RaceBike{" + super.toString() + '}';
    }
    
}
