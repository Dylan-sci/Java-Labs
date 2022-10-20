package dendrologist;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * A testbed for an augmented implementation of an AVL tree
 * @author William Duncan, Dylan Scivicque
 * @see AVLTreeAPI
 * <pre>
 * Date: 10-19-2022
 * Course: CSC 3102 
 * Programming Project # 2
 * Instructor: Dr. Duncan 
 * </pre>
 */
public class Dendrologist
{
    public static void main(String[] args) throws FileNotFoundException 
    {
        String usage = "Dendrologist <order-code> <command-file>\n";
        usage += "  <order-code>:\n";
        usage += "  0 ordered by increasing string length, primary key, and reverse lexicographical order, secondary key\n";
        usage += "  -1 for reverse lexicographical order\n";
        usage += "  1 for lexicographical order\n";
        usage += "  -2 ordered by decreasing string\n";
        usage += "  2 ordered by increasing string\n";
        usage += "  -3 ordered by decreasing string length, primary key, and reverse lexicographical order, secondary key\n";
        usage += "  3 ordered by increasing string length, primary key, and lexicographical order, secondary key\n";      
        if (args.length != 2)
        {
            System.out.println(usage);
            throw new IllegalArgumentException("There should be 2 command line arguments.");
        }
        
        AVLTree tree = new AVLTree();
        try
        {
            if (!"strings.avl".equals(args[1]))
            {
                throw new FileNotFoundException();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(usage);
        }  

        FileReader file = new FileReader("src\\strings.avl");
        Scanner sc = new Scanner((file));
        
        while (sc.hasNextLine())
        {
            String[] command = sc.nextLine().split(" ");
            switch(command[0])
            {
                case "insert":
                {
                    tree.insert(command[1]);
                    System.out.println("Inserted: " + command[1]);
                }
                break;
                case "delete":
                {
                    tree.remove(command[1]);
                    System.out.println("Deleted: " + command[1]);
                }
                break;
                case "traverse":
                {
                    System.out.println("In-Order Traversal: ");
                    tree.traverse((s) -> {
                    System.out.println(s);
                    return s;
                    });
                }
                break;
                case "paths":
                {
                    System.out.println("#Root-to-Leaf Paths:" + tree.genPaths().size());
                    System.out.println(tree.genPaths());
                }
                break;
                case "stats":
                {
                    System.out.println("Stats: size = " + tree.size() + ", height = " + tree.height() + ", #full-nodes = " + tree.fullCount() + ", fibonacci? = " + tree.isFibonacci());
                }
                break;
                default:
                {
                    System.out.println("Parsing Error.");
                    throw new IllegalArgumentException();

                }
                
            }
            
        }
        
    }
    //complete the implementation of this method
}
