package circularqueue;

/**
 *
 * @author dscivi1
 */
public class CircularQueue<E> implements CircularQueueInterface<E>
{
    private Node rear;
    private int length;

    
    /**
     * this inner class is used to create nodes of a singly-linked queue
     */
    private class Node
    {
       public E data;
       public Node next;
    }

    
    /**
     * Creates an empty singly-linked queue
     */
    public CircularQueue()
    {
        rear = null;
        length = 0;
    }

    
    public int size()
    {
        return length;
    }

    
    /**
     * Determines whether the queue is empty.
     * @return true if the queue is empty;
     * otherwise, false
     */
    public boolean isEmpty()
    {
        if (length == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    
    /**
     * Inserts an item at the back of the queue.
     * @param data the value to be inserted.
     */
    public void enqueue(E data) 
    {
        Node newNode = new Node();
        newNode.data = data;
        if(isEmpty())
        {
            newNode.next = newNode;
        }
        else
        {
            Node head = rear.next;
            newNode.next = head;
            rear.next = newNode;
        }
        length++;
        rear = newNode;
    }

    
    /**
     * Accesses the item at the front of a non-empty queue
     * @return item at the front of the queue.
     * @throws Exception when this queue is empty
     */
    public E front() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("Non-empty queue expected");
        }
        Node head = rear.next;
        return head.data;
    }

    
    /**
     * Deletes an item from the front of the queue.
     * @return item at the front of the queue.
     * @throws Exception when this queue is empty
     */
    public E dequeue() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("Non-empty queue expected");
        }
        Node head = rear.next;
        E data = head.data;
        if (length == 1)
        {
            rear = null;
        }
        else
        {
            rear.next = head.next;
        }
        length--;
        return data;
    }


    /**
     * Moves the node at the back of the queue to the front.
     */
    public void rotateCounterclockwise()
    {
        Node head = rear.next;
        Node node = head;
        while (node.next != rear)
        {
            node = node.next;
        }
        rear = node;
    }

    
    /**
     * Moves the node at the front of the queue to the back.
     */
    public void rotateClockwise()
    {
        Node head = rear.next;
        rear = head;
    }

    
    /**
     * Returns a string [en-1, ..., e2, e1, e0] representing this queue, 
     * where e0 is the data item in the head node and en-1 is the data item
     * in the rear node. It returns [] if this queue is empty.     
     */	 
    public String toString()
    {
        String string = "]";
        if(!isEmpty())
        {
            Node head = rear.next;
            Node node = head;
            string = node.data + string;
            while(node.next != head)
            {
                node = node.next;
                string = node.data + ", " + string;
            }
        }
        string = "[" + string;
        return string;
    }	    
}
