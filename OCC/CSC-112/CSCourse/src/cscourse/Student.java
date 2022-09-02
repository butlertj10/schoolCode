package cscourse;

/**
 *
 * @author Trev
 */
public class Student 
{
    private static final int MAX_COURSES = 6;
    private int numCourses;
    private String name;
    private Course[] courseList;
    
    
    public Student(String name) 
    {
        this.name = name;
        courseList = new Course[MAX_COURSES];
        numCourses = 0;
    }

    public void AddCourse(Course c)
    {
        if(numCourses != MAX_COURSES)
        {
            courseList[numCourses] = c;
            numCourses++;
        }
        else
        {
            System.out.println("You have reached the MAX number of courses");
        }
    }
    
    @Override
    public String toString() 
    {
        String msg;
        
        msg = "Student name: " + name + "\n"
                + "numCourses: " + numCourses + "\n";
        
        for(Course temp : courseList)
        {
            if(temp != null)
                // Calling toString (temp.toString)
                msg += temp + "\n";
        }
        
        return msg;
    }
    
    
}
