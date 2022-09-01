package prog06_partypooper;
import java.util.Scanner;

/**
 * This project calculates if the number of people leaving and entering a party exceeds the max capacity for the venue.
 * 
 * CSC 1350 Programming project No 6
 * 
 * 
 * @author Dylan Scivicque dscivi1
 * @since 10/23/2021
 * 
 */

public class Prog06_PartyPooper
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of people that can attend an event at the party venue: ");
        if (!in.hasNextInt())
        {
            do
            {
                in.nextLine();
                System.out.println("Value must be a whole number. Try again.");
                System.out.println("Enter number of people that can attend an event at the party venue: ");
            }
            while (!in.hasNextInt());
        }
        int peopleLimit = in.nextInt();
        
        int totalAmount = 0;
        while (totalAmount < peopleLimit)
        {
            in.nextLine();
            System.out.println("Enter number of people entering/leaving the party: ");
            if (!in.hasNextInt())
            {
                do
                {
                    in.nextLine();
                    System.out.println("Value must be a whole number. Try again.");
                    System.out.println("Enter number of people entering/leaving the party: ");
                }
                while (!in.hasNextInt());
            }
            int peopleAmount = in.nextInt();
            if (peopleAmount < 0)
            {
               totalAmount = peopleAmount + totalAmount;
            }
            else
            {
                totalAmount = peopleAmount + totalAmount;
            }
        }
        
        System.out.println("There are " + totalAmount + " in the party. This excced the venue limit of " + peopleLimit + ". Party's over!");
    }
    
}