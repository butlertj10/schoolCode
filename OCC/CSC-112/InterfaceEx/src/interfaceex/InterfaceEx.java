package interfaceex;

/**
 *
 * @author t.j.butler2
 */
public class InterfaceEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Person person1 = new Person("Mary", 44);
        Person person2 = new Person("Dave", 42);

        Person myPeople[] = new Person[2];

        System.out.println(person1);
        System.out.println(person2);

        myPeople[0] = person1;
   
        if (myPeople[0].compareTo(person2) <= 0) {
            myPeople[1] = person2;
        } else {
            myPeople[1] = myPeople[0];
            myPeople[0] = person2;
        }

        System.out.println("\nOrdered");
        System.out.println("-------");


        for (Person temp : myPeople) 
        {
            System.out.println(temp);
        }
        
        Student student1 = new Student(3.26, "Mark", 19);
        Student student2 = new Student(3.68, "Jeff", 20);
        
        Student myStudents [] = new Student[2];
        myStudents[0] = student1;
        

    }

}
