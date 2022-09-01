package stack2;

public class Stack2Demo 
{
    public static void main(String[] args)
    {
        try
        {
            Stack2<Integer> nums = new Stack2<>();
            nums.push(12);
            System.out.printf("%d pushed onto the stack.\n",nums.getTop());
            nums.push(4);
            System.out.printf("%d pushed onto the stack.\n",nums.getTop());
            nums.push(51);
            System.out.printf("%d pushed onto the stack.\n",nums.getTop());
            nums.push(1);
            System.out.printf("%d pushed onto the stack.\n",nums.getTop());
            nums.push(16);
            System.out.printf("%d pushed onto the stack.\n",nums.getTop());
            nums.push(5);
            System.out.printf("%d pushed onto the stack.\n\n",nums.getTop());
            System.out.println("Stack = " + nums);
            System.out.println();
            
            if (!nums.isEmpty())
                System.out.println("The stack is not empty.");
            else
                System.out.println("The stack is empty.");
            System.out.println();

            nums.moveTopNodeToBottom();
            System.out.println("After moving top node to bottom, stack = " 
                    + nums);
            nums.moveBottomNodeToTop();
            System.out.println("After moving bottom node to top, stack = " 
                    + nums);
            System.out.println();


            
            while (!nums.isEmpty())
            {
                System.out.printf("%d is at the top of the stack.\n",
                        nums.getTop());
                System.out.printf("%d has been popped off of the stack.\n",
                        nums.pop());
                System.out.println("Stack = " + nums);
                System.out.println();
            }
            
            if (!nums.isEmpty())
                System.out.println("The stack is not empty.");
            else
                System.out.println("The stack is empty.");
            System.out.println();
           
            System.out.println("Calling nums.getTop()");
            System.out.printf("%d is at the top of the stack.\n",
                    nums.getTop());           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

