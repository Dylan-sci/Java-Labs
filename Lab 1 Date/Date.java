package date;

/**
 *
 * @author dscivi1
 */
public class Date {
    private int month;
    private int day;
    private int year;
    
    String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
    String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    
    public String getMonth()
    {
        return months[month - 1];
    }
    
    public int getDay()
    {
        return day;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public void setDate(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;
    }
    
    public String getWeekDay()
    {
        int u = 2*(3 - (year / 100 % 4));
        int v = year % 100;
        int w = v / 4;
        int x = 0;
        int[] tableLeap = { 6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };
        int[] tableNormal = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
        {
            x = tableLeap[month - 1];
        }
        else
        {
            x = tableNormal[month - 1];
        }
        int y = u + v + w + x + day;
        y = y % 7;
        return days[y];
    }
    
}