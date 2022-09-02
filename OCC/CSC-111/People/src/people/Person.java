/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author Trev
 */
public class Person 
{
    private String name;
    private int age;
    private Address myAddress;
    
    public Person() 
    {
        
    }

    public Person(String name, int age, String street, String city, String state, int zipCode) 
    {
        this.name = name;
        this.age = age;
        myAddress = new Address(street, city, state, zipCode);

    }

    // Getters and Setters
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getAge() 
    {
        return age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public String getStreet() 
    {
        return myAddress.getStreet();
    }

    public void setStreet(String street)
    {
        myAddress.setStreet(street);
    }

    public String getCity() 
    {
        return myAddress.getCity();
    }

    public void setCity(String city) 
    {
        myAddress.setCity(city);
    }

    public String getState() 
    {
        return myAddress.getState();
    }

    public void setState(String state) 
    {
        myAddress.setState(state);
    }

    public int getZipCode() 
    {
        return myAddress.getZipCode();
    }

    public void setZipCode(int zipCode) 
    {
        myAddress.setZipCode(zipCode);
    }
    
    
   @Override
    public String toString() 
    {
        return "Person{" + "name = " + name + ", age = " + age + ", street = " + 
                myAddress.getStreet() + ", city = " + myAddress.getCity() + ", "
                + "state = " + myAddress.getState() + ", zipCode = " 
                + myAddress.getZipCode() + '}';
        
        // Other way ^^
        /*
            return "Person{" + "name = " + name + ", age = " + age + "," 
            + myAddress + '}';
        */
    } 
    
    
    
}
