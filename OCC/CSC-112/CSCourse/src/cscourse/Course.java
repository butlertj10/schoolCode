package cscourse;

/**
 *
 * @author Trev
 */
public class Course 
{
    private final int CLASS_SIZE = 3;
    private String courseName;
    private int section;
    private int numStudents;
    
    public Course(String courseName, int section)
    {
        this.courseName = courseName;
        this.section = section;
        numStudents = 0;
    }

    @Override
    public String toString() 
    {
        return "Course{" + "courseName: " + courseName + 
                ", section: " + section + ", numStudents: " 
                + numStudents + '}';
    }
    
    
}
