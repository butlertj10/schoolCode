/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentschedule;

/**
 *
 * @author Trev
 */
public class StudentSchedule 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Student trev = new Student("Trevor Butler", "012345", "123 School Lane", "Syracuse", "New York", "12345",
        "Computer Science");
        
        Student rick = new Student("Ricky Spanish", "23456", "325 Riverside Road", "Syracuse", "New York", "13084",
        "Computer Science");
                
        System.out.println(trev);
        trev.AddCourse("CSC111", 3);
        trev.AddCourse("CSC112", 4);
        trev.AddCourse("GEO101", 3);
        trev.AddCourse("ENG104", 2);
        trev.AddCourse("MAT161", 4);
        trev.AddCourse("COM101", 1);
        trev.AddCourse("PHI101", 1); 
        System.out.println(trev.DisplaySchedule());
        System.out.println("Total Credits: " + trev.TotalCredits());
//        System.out.println("\n" + rick);
//        rick.AddCourse("HIS104", 4);
//        System.out.println(rick.DisplaySchedule());
//        System.out.println("Total Credits: " + rick.TotalCredits());
        trev.searchCourse("CSC111");
        trev.DropCourse("COM101");
        trev.DropCourse("MAT161");
        System.out.println(trev.DisplaySchedule());
    }
    
}
