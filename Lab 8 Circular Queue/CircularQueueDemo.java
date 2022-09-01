package circularqueue;

public class CircularQueueDemo
{
    public static void main(String []args)
    {
        try
        {
            CircularQueue<Character> chars = new CircularQueue();
            chars.enqueue('S');
            System.out.printf("%c inserted in the queue.\n",'S');
            chars.enqueue('T');
            System.out.printf("%c inserted in the queue.\n",'T');
            chars.enqueue('R');
            System.out.printf("%c inserted in the queue.\n",'R');
            chars.enqueue('E');
            System.out.printf("%c inserted in the queue.\n",'E');
            chars.enqueue('S');
            System.out.printf("%c inserted in the queue.\n",'S');        
            chars.enqueue('S');
            System.out.printf("%c inserted in the queue.\n",'S');
            chars.enqueue('E');
            System.out.printf("%c inserted in the queue.\n",'E');        
            chars.enqueue('D');
            System.out.printf("%c inserted in the queue.\n",'D');
            System.out.println();
            
            System.out.println("Queue = " + chars);
            System.out.println();
            
            if (!chars.isEmpty())
                System.out.println("The queue is not empty.");
            else
                System.out.println("The queue is empty.");
            System.out.println();
            
            chars.rotateCounterclockwise();
            System.out.println("After rotating counterclockwise, queue = " 
                    + chars);
            chars.rotateClockwise();
            System.out.println("After rotating clockwise, queue = " + chars);
            System.out.println();
            
            while (!chars.isEmpty())
            {
                System.out.printf("%c is at the front of the queue.\n",
                        chars.front());
                System.out.printf("%c has been removed from the queue.\n",
                        chars.dequeue());
                System.out.println("Queue = " + chars);
                System.out.println();
            }
            
            if (!chars.isEmpty())
                System.out.println("The queue is not empty.");
            else
                System.out.println("The queue is empty.");
            System.out.println();
                        
            System.out.println("Calling nums.front()");
            System.out.printf("%c is at the front of the queue.\n",
                    chars.front());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
