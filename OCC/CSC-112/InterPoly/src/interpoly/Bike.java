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
public class Bike implements BikeInterface 
{
    protected int gear;
    protected int speed;
    
    public Bike(int gear, int speed)
    {
        this.gear = gear;
        this.speed = speed;
    }

    @Override
    public String toString() 
    {
        return "Bike{" + "gear=" + gear + ", speed=" + speed + '}';
    }  

    @Override
    public void changeGear(int decrement) 
    {
        speed -= decrement;
    }

    @Override
    public void speedUp(int increment) 
    {
        speed += increment;
    }
}
