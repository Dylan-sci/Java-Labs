package recursiveauxiliarymath;
import java.util.Scanner;
import static recursiveauxiliarymath.RecursiveAuxiliaryMath.recursiveIsPalindrome;
import static recursiveauxiliarymath.RecursiveAuxiliaryMath.recursiveGCD;
import static recursiveauxiliarymath.RecursiveAuxiliaryMath.recursiveFibonacci;
import static recursiveauxiliarymath.RecursiveAuxiliaryMath.recursivePowInt;

/**
 *
 * @author dscivi1
 */
public class RecursiveAuxiliaryMathDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter three integers whose GCD is to be found -> ");
        int firstInt = in.nextInt();
        int secondInt = in.nextInt();
        int thirdInt = in.nextInt();
        int gcd = recursiveGCD(recursiveGCD(firstInt, secondInt), thirdInt);
        
        System.out.println("Enter an integer n to sum the fibonacci series up to fibonacci (n) -> ");
        int n = in.nextInt();
        long fibonacciSum = recursiveFibonacci(n);
        
        System.out.println("Enter the base and exponent, an integer, of a power -> ");
        double base = in.nextDouble();
        int exponent = in.nextInt();
        double fibonacciPower = recursivePowInt(base, exponent);
        
        System.out.println("Enter two positive integers i and j where i < j -> ");
        int i = in.nextInt();
        int j = in.nextInt();
        int int1 = i;
        int int2 = j;
        int count = 0;
        while (int1 <= int2)
        {
            String nums = "" + int1;
            if (recursiveIsPalindrome(nums, 0, nums.length()-1))
            {
                count++;
            }
            int1++;
        }
        
        System.out.println("gcd(" + firstInt + "," + secondInt + "," + thirdInt + ") = " + gcd);
        System.out.println("Sum up to fibonacci(" + n + ") = " + fibonacciSum);
        System.out.printf("%.6f ^ %d = %.6f\n", base, exponent, fibonacciPower);
        System.out.println("There are " + count + " palindromic numbers between " + i + " and " + j);
        
    }
    
}