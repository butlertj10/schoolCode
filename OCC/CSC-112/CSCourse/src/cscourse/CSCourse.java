package cscourse;

/**
 *
 * @author Trev
 */
public class CSCourse 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Declares/Prints Courses
        Course course1 = new Course("CSC 112", 501);
        Course course2 = new Course("CSC 111", 301);
        Course course3 = new Course("ENG 110", 203);
        Course course4 = new Course("MAT 161", 211);
        System.out.println(course1);
        System.out.println(course2);
        System.out.println(course3);
        System.out.println(course4);
        
        // Declares/Prints student 1
        Student student1 = new Student("Trevor Butler");
        System.out.println(student1);
        
        // Adding courses
        student1.AddCourse(course1);
        student1.AddCourse(course2);
        student1.AddCourse(course3);
        student1.AddCourse(course4);
        
        
    }
    
}
