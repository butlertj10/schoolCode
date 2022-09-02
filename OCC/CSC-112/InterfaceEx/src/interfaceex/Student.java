/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceex;

/**
 *
 * @author t.j.butler2
 */
public class Student extends Person
{
    private double gpa;

    public Student(double gpa, String name, int age)
    {
        super(name, age);
        this.gpa = gpa;
    }

    @Override
    public String toString() 
    {
        return "Student{" + "gpa=" + gpa + '}';
    }
    
    @Override
    public int compareTo(Object obj)
    {
        int result;
        Student temp = (Student)obj;
        
        result = super.compareTo(obj);
        
        if(result < 0 && gpa < temp.gpa)
            result = -1;
        else if(result > 0 && gpa > temp.gpa)
            result = 1;
        else
            result = 0;
        
        return result;
    }
 }
