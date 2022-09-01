package sorttimer;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dscivi1
 */
public class SortTimer {
    
    public static void selectionSort(int[] nums)
    {
        int min;
        int minPos;
        for (int i = 0; i < nums.length - 1; i++)
        {
            min = nums[i];
            minPos = i;
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[j] < min)
                {
                    min = nums[j];
                    minPos = j;
                }
            }
            if (minPos != i)
            {
                int temp = nums[i];
                nums[i] = nums[minPos];
                nums[minPos] = temp;
            }
        }
    }
    
    public static void selectionSortPrint(int[] nums)
    {
        int min;
        int minPos;
        for (int i = 0; i < nums.length - 1; i++)
        {
            min = nums[i];
            minPos = i;
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[j] < min)
                {
                    min = nums[j];
                    minPos = j;
                }
            }
            if (minPos != i)
            {
                int temp = nums[i];
                nums[i] = nums[minPos];
                nums[minPos] = temp;
            }
            System.out.println("nums = " + Arrays.toString(nums));
        }
    }
    
    public static void insertionSort(int[] nums)
    {
        for (int i = 1; i < nums.length; i++)
        {
           int next = nums[i];
           int j = i;
           while (j > 0 && nums[j - 1] > next)
           {
              nums[j] = nums[j - 1];
              j--;
           }
           nums[j] = next;
        }
    }
    
    public static void insertionSortPrint(int[] nums)
    {
        for (int i = 1; i < nums.length; i++)
        {
           int next = nums[i];
           int j = i;
           while (j > 0 && nums[j - 1] > next)
           {
              nums[j] = nums[j - 1];
              j--;
           }
           nums[j] = next;
           System.out.println("nums = " + Arrays.toString(nums));
        }
    }
    
    public static void main(String[] args) {
        
        int[] numsSelection = {5,6,4,7,2,1,8,3};
        System.out.println("Selection Sort:");
        System.out.println("nums = " + Arrays.toString(numsSelection));
        selectionSortPrint(numsSelection);
        System.out.println();
        
        int[] numsInsertion = {5,8,4,6,2,1,7,3};
        System.out.println("Insertion Sort:");
        System.out.println("nums = " + Arrays.toString(numsInsertion));
        insertionSortPrint(numsInsertion);
        System.out.println();
                
        int seed = 0;
        Random rand = new Random(seed);
        int maxRandomValue = 1000000;
        int numRuns = 3;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the starting value for the length n of "
                + "the array to be sorted, the stepsize by which n is "
                + "increased, and the number of steps: ");
        int start = in.nextInt();
        int stepSize = in.nextInt();
        int numSteps = in.nextInt();
        int end = start + numSteps * stepSize;
        System.out.println();
        
        for (int n = start; n <= end; n += stepSize)
        {            
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            long sum1 = 0;
            long sum2 = 0;
            int m;
            
            for (int j = 1; j <= numRuns; j++)
            {                    
                for (int i = 0; i < n; i++)
                {
                    m = rand.nextInt(maxRandomValue) + 1;
                    nums1[i] = m;
                    nums2[i] = m;
                }
                
                long startTime = System.currentTimeMillis();
                selectionSort(nums1);
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                sum1 += elapsedTime;
                
                startTime = System.currentTimeMillis();
                insertionSort(nums2);
                endTime = System.currentTimeMillis();
                elapsedTime = endTime - startTime;
                sum2 += elapsedTime;

            }
            long average1 = (long)(1. * sum1 / numRuns);
            long average2 = (long)(1. * sum2 / numRuns);
            System.out.printf("n = %6d   Sort Run Time (milliseconds):  "
                    + "Selection: %4d   Insertion: %4d\n",
                    n, average1, average2);
        }
    }
}
