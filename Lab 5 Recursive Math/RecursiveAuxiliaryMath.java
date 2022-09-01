package recursiveauxiliarymath;

/**
 *
 * @author dscivi1
 */
public class RecursiveAuxiliaryMath {

    public static boolean recursiveIsPalindrome(String num, int i, int j)
    {
        if (i >= j)
        {
            return true;
        }
        else
        {
            char first = num.charAt(i);
            char last = num.charAt(j);
            if (first != last)
            {
                return false;
            }
            else
            {
                return recursiveIsPalindrome(num, i + 1, j-1);
            }
        }
    }
    
    public static long recursiveFibonacci(int n)
    {
        if (n <= 1)
        {
            return n;
        }
        else
        {
            return (recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2));
        }
    }
    
    public static int recursiveGCD(int a, int b)
    {
        int r;
        if (a == 0 && b == 0)
        {
            return 0;
        }
        else if (a == 0 || b == 0)
        {
            if (a < 0)
            {
                a = -a;
            }
            else if (b < 0)
            {
                b = -b;
            }
            return a + b;
        }
        else
        {
            if (a < 0)
            {
                a = -a;
            }
            else if (b < 0)
            {
                b = -b;
            }
            if (b != 0)
            {
                return recursiveGCD(b, a % b);
            }
            else
            {
                return a;
            }
        }
    }
    
    public static double recursivePowInt(double a, int n)
    {
        if (n == 0)
        {
            return 1;
        }
        else if (n > 0)
        {
            return (a * recursivePowInt(a, n - 1));
        }
        else
        {
            return 1.0 / recursivePowInt(a, -n);
        }
    }
    
}