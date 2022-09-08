/**
 * A program to profile the Eratosthene's Sieve prime generator
 * and compare the exact value of the prime-counting function and
 * the n/ln(n) approximation.
 * CSC 3102 Programming Project # 0
 * @author Duncan, Dylan Scivicque
 * @see EratosthenesUtil
 * <pre>
 * Date: 9/4/2022
 * Course: CSC 3102 Section 1
 * Instructor: Dr. Duncan
 * Project: 0
 * </pre>
 */
 
import java.util.ArrayList;
import java.util.Scanner;
public class EratosthenesProfiler
{
	public static void main(String[] args) 
	{
            Scanner scanner = new Scanner(System.in);
            EratosthenesUtil integers = new EratosthenesUtil();
            System.out.print("Enter an integer n to generate primes in [2,n]-> ");
            int n = scanner.nextInt();
            long before = System.nanoTime();
            ArrayList<Long> result = integers.sieve(n);
            long after = System.nanoTime();
            String output = integers.toString(result);
            System.out.println("P(" + n + ") = " + output);
            long time = (after - before) / 1000;
            System.out.println("Time to Generate the Primes: " + time + " microseconds");
            System.out.println("pi(" + n + ") = " + result.size());
            System.out.printf("%n%-7s %-9s %-6s %-8s %s", "n", "Time(us)", "pi(n)", "n/ln(n)", "%Error in pi(n)\n");
            for (int i = 10000; i <= 150000; i += 10000)
            {
                long beforei = System.nanoTime();
                ArrayList<Long> resulti = integers.sieve(i);
                long afteri = System.nanoTime();
                long timei = (afteri - beforei) / 1000;
                long size = resulti.size();
                double nln = i / (Math.log(i));
                double percentageErr = Math.abs(((nln - size) / size) * 100);
                System.out.printf("%-7s %-9s %-6s %-8.1f %%%-10.2f\n", i, timei, size, nln, percentageErr);
            }
	}
}