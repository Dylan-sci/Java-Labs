import date.Date;
import java.util.Scanner;

/**
 *
 * @author dscivi1
 */
public class DateDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first day of class -> ");
        String line = in.nextLine();
        String[] nums = line.split("/");
        int m1 = Integer.parseInt(nums[0]);
        int d1 = Integer.parseInt(nums[1]);
        int y1 = Integer.parseInt(nums[2]);
        System.out.print("Enter the last day of class -> ");
        String line1 = in.nextLine();
        String[] nums1 = line1.split("/");
        int m2 = Integer.parseInt(nums1[0]);
        int d2 = Integer.parseInt(nums1[1]);
        int y2 = Integer.parseInt(nums1[2]);
        
        Date first = new Date();
        Date last = new Date();
        
        first.setDate(m1, d1, y1);
        String month1 = first.getMonth();
        int day1 = first.getDay();
        int year1 = first.getYear();
        String weekDay1 = first.getWeekDay();
        
        last.setDate(m2, d2, y2);
        String month2 = last.getMonth();
        int day2 = last.getDay();
        int year2 = last.getYear();
        String weekDay2 = last.getWeekDay();
        
        System.out.println("First day of class: " + weekDay1 + ", " + month1 + " " + day1 + ", " + year1);
        System.out.println("Last day of class: " + weekDay2 + ", " + month2 + " " + day2 + ", " + year2);
        
    }
    
}