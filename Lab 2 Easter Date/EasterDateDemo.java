package easterdate;
import java.util.Scanner;

/**
 *
 * @author dscivi1
 */
public class EasterDateDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = in.nextInt();
        
        EasterDate date = new EasterDate();
        
        date.setYear(year);
        int[] EasterArray = date.getEasterMonthAndDay();
        date.setMonthAndDay(EasterArray[1], EasterArray[0]);
        String weekDay = date.getWeekDay();
        String month = date.getMonth();
        int day = date.getDay();
        System.out.println("In " + year + ", Easter falls on " + weekDay + ", " + month + " " + day);
        
    }
    
}