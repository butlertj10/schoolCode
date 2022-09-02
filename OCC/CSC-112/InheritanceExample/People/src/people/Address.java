/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author speciosr
 */
public class Address 
{
    private String street;
    private String city;
    private String state;
    private int zipCode;

    public Address(String street, String city, String state, int zipCode) 
    {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() 
    {
        return "Address{" + "street=" + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + '}';
    }

    public String getStreet() 
    {
        return street;
    }

    public void setStreet(String street) 
    {
        this.street = street;
    }

    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getState() 
    {
        return state;
    }

    public void setState(String state) 
    {
        this.state = state;
    }

    public int getZipCode() 
    {
        return zipCode;
    }

    public void setZipCode(int zipCode) 
    {
        this.zipCode = zipCode;
    }
    
    
}
