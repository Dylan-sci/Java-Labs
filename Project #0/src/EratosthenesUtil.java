/**
 * Provides an implementation for the Eratosthene's sieve generator
 * CSC 3102 Programming Project # 0
 * @author Duncan, Dylan Scivicque
 * <pre>
 * Date: 9/4/2022
 * Course: CSC 3102 Section 1
 * Instructor: Dr. Duncan
 * Project: 0
 * </pre>
 */

import java.util.ArrayList;
import java.util.Arrays;

class EratosthenesUtil
{
    /**
     * Generates a sequence of all primes less than the specified parameter
     * @param n the upperbound on the prime sequence
     * @return an array list containing all primes in [2,n] or an empty array
	 * list if n < 2.
     */
    public static ArrayList<Long> sieve(long n)
    {
        ArrayList<Long> primes = new ArrayList<>(Arrays.asList());
        int integers = (int) n;
                if (n < 2)
                {
                    return new ArrayList<>();
                }
                else
                {
                    boolean[] isPrime = new boolean[integers];
                    Arrays.fill(isPrime, true);
                    for (int i = 2; i <= Math.sqrt(n); i++)
                    {
                        if (isPrime [i] == true)
                        {
                            for (int j = i*i; j < n; j += i)
                            {
                                isPrime [j] = false;
                            }
                        }
                    }
                    for (int i = 2; i < n; i++)
                    {
                        if (isPrime [i] == true)
                        {
                            primes.add(Long.valueOf(i));
                        }
                    }
                }
		return primes;
    }
    /**
     * Gives a string representation of the specified array list of longs
     * enclosed in a pair of curly brackets and each adjacent pair of primes 
     * separated by a comma followed by a space.
     * @param v an array list of longs
     * @return a string representation of an array list of longs
     */
    public static String toString(ArrayList<Long> v)
    {
        return v.toString();
    }
}