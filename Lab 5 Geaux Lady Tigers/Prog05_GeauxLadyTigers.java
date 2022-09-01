package prog05_geauxladytigers;
import java.util.Scanner;

/**
 * This program takes input from the user to calculate the sum of the top five individual scores for the LSU women's gymnastics events.
 * 
 * CSC 1350 Programming project No 5
 *
 * @author Dylan Scivicque dscivi1
 * @since 10/15/2021
 *
 */


public class Prog05_GeauxLadyTigers {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean correctEventName = false;
        String event = "";
        
        while (!correctEventName)
        {
            System.out.println("Enter gymnastics event to evaluate(bars, vault, floor, or beam):");
            event = in.next();
            switch (event)
            {
             case "bars":
                  correctEventName = true;
                  break;
             case "vault":
                  correctEventName = true;
                  break;
             case "floor":
                  correctEventName = true;
                  break;
             case "beam":
                 correctEventName = true;
                 break;
            }
            if (!correctEventName)
            {
                System.out.println("Invalid event name entered.");
            }
        }
        double totalScore = 0;
        double lowestScore = 11;
        
        for (int count = 0; count < 6; count++)
        {
            boolean correctScore = false;
            
            while (!correctScore)
            {
                System.out.println("Enter individual event score (0.0 - 10.0):");
                double eventScore = in.nextDouble();
                   
                if (eventScore < 0.0 || eventScore > 10.0)
                {
                    System.out.println("Invalid score entered");
                }
                else
                {
                    correctScore = true;
                    totalScore = eventScore + totalScore;
                    if (lowestScore > eventScore)
                    {
                        lowestScore = eventScore;
                    }
                }
            }
        }
        totalScore = totalScore - lowestScore;
        System.out.printf("LSU Women's Gymnastics Team %s Score: %.3f", event, totalScore);
            
    }
    
}