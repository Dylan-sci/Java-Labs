package statisticsdemo;

/**
 *
 * @author dscivi1
 */
public class Student implements Measureables, Comparable {
    private String name;
    private int exam1;
    private int exam2;
    private int finalExam;
    private double courseGrade;
    
    public Student(String name, int exam1, int exam2, int finalExam)
    {
        this.name = name;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.finalExam = finalExam;
        
        courseGrade = (exam1 + exam2 + finalExam) / 3.0;
        
    }
    
    public int getFirstInt() { return exam1; }
    public int getSecondInt() {return exam2; }
    public int getThirdInt() { return finalExam; }
    public double getDouble() { return courseGrade; }
    
    public int compareTo(Object otherObject)
    {
        Student other = (Student) otherObject;
        if (this.courseGrade < other.courseGrade)
        {
            return -1;
        }
        else if (this.courseGrade > other.courseGrade)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    public String toString()
    {
        return String.format("%.1f", courseGrade);
    }
    
}