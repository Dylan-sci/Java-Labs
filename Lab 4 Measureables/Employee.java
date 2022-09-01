package statisticsdemo;

/**
 *
 * @author dscivi1
 */
public class Employee implements Measureables, Comparable {
    private String name;
    private int hours;
    private int rate;
    private int sales;
    private double netPay;
    
    public Employee(String name, int hours, int rate, int sales)
    {
        this.name = name;
        this.hours = hours;
        this.rate = rate;
        this.sales = sales;
        
        double wages = hours * rate;
        double comission = sales * .15;
        double grossPay = wages + comission;
        double withholdingTax = grossPay * .18;
        netPay = grossPay - withholdingTax;
    }
    
    public int getFirstInt() { return hours; }
    public int getSecondInt() {return rate; }
    public int getThirdInt() { return sales; }
    public double getDouble() { return netPay; }
    
    public int compareTo(Object otherObject)
    {
        Employee other = (Employee) otherObject;
        if (this.netPay < other.netPay)
        {
            return -1;
        }
        else if (this.netPay > other.netPay)
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
        return String.format("$%.2f", netPay);
    }
    
}