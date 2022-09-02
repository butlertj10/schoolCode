package interfaceex;

/**
 *
 * @author t.j.butler2
 */
public class Person implements Comparable
{
    protected String name;
    protected int age;
    
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() 
    {
        return "\nPerson\n" + "Name: " + name + "\nAge: " + age;
    }
    
    public int compareTo(Object obj)
    {
        int result = 0;
        Person temp = (Person)obj;
        
        if(name.compareTo(temp.name) < 0)
            result = -1;
        else if(name.compareTo(temp.name) > 0)
            result = 1;
        return result;
    }
}
