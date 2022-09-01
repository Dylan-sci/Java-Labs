package easterdate;

/**
 *
 * @author dscivi1
 */
public class EasterDate {
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
    
    public void setYear(int y) {
        year = y;
    }
    
    public void setMonthAndDay(int m, int d) {
        month = m;
        day = d;
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
    
    public int[] getEasterMonthAndDay() {
        int y = year;
        int a = y % 19;
        int b = y / 100;
        int c = y % 100;
        int d = b / 4;
        int e = b % 4;
        int g = (8 * b + 13) / 25;
        int h = (19 * a + b - d - g + 15) % 30;
        int j = c / 4;
        int k = c % 4;
        int m = (a + 11 * h) / 319;
        int r = (2 * e + 2 * j - k - h + m + 32) % 7;
        int n = (h - m + r + 90) / 25;
        int p = (h - m + r + n + 19) % 32;
        
        int[] dateArray = { p, n };
        return dateArray;
        
    }
    
}