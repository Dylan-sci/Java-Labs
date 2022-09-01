package statisticsdemo;
import java.util.Arrays;

/**
 *
 * @author dscivi1
 */
public class StatisticsDemo {

    public static void main(String[] args) {
        
        Student[] students = new Student[6];        
        students[0] = new Student("Mary", 85, 93, 97);
        students[1] = new Student("Bob", 67, 77, 71);
        students[2] = new Student("Tom", 85, 91, 89);
        students[3] = new Student("Anna", 79, 72, 80);
        students[4] = new Student("Hal", 96, 88, 99);
        students[5] = new Student("Gina", 89, 91, 82);

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Sara", 68, 19, 5473);
        employees[1] = new Employee("Sam", 51, 18, 5829);
        employees[2] = new Employee("Lisa", 47, 16, 3892);
        employees[3] = new Employee("Jim", 33, 21, 4857);
        employees[4] = new Employee("Judy", 39, 23, 4295);

        System.out.println("Students:  " + Arrays.toString(students));
        System.out.println();
        
        double[] avgs = averages(students);
        System.out.printf("Average Exam 1 Grade = %.2f\n", avgs[0]);
        System.out.printf("Average Exam 2 Grade = %.2f\n", avgs[1]);
        System.out.printf("Average Final Exam Grade = %.2f\n", avgs[2]);
        System.out.printf("Average Course Grade = %.2f\n", avgs[3]);       
        System.out.println();
        
        Arrays.sort(students);
        System.out.println("After sorting students by course grade, ");
        System.out.println("Students:  "+ Arrays.toString(students));
        System.out.println();
        System.out.println("Employees:  " + Arrays.toString(employees));
        System.out.println();
       
        avgs = averages(employees);
        System.out.printf("Average Hours = %.2f\n", avgs[0]);
        System.out.printf("Average Rate = $%.2f\n", avgs[1]);
        System.out.printf("Average Sales = $%.2f\n", avgs[2]);
        System.out.printf("Average Net Pay = $%.2f\n", avgs[3]);
        System.out.println();
        
        Arrays.sort(employees);
        System.out.println("After sorting employees by net pay, ");
        System.out.println("Employees:  " + Arrays.toString(employees));
        System.out.println();
        
    }
    
    public static double[] averages(Measureables[] objects)
    {
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;
        double sum4 = 0;
        int n = objects.length;
        double[] avgArr = new double[n];
        
        for(int i = 0; i < n; i++)
        {
            sum1 += objects[i].getFirstInt();
            sum2 += objects[i].getSecondInt();
            sum3 += objects[i].getThirdInt();
            sum4 += objects[i].getDouble();
        }
        double avg1 = sum1/n;
        double avg2 = sum2/n;
        double avg3 = sum3/n;
        double avg4 = sum4/n;
        
        avgArr[0] = avg1;
        avgArr[1] = avg2;
        avgArr[2] = avg3;
        avgArr[3] = avg4;
        
        return avgArr;
    }
    
}