package stack2;
import java.util.List;

/**
 *
 * @author dscivi1
 */
public class Stack2<E> implements Stack2Interface<E> 
{
    private Node top;
    private Node bottom;
    private int length;
    
    private class Node
    {
        public E data;
        public Node next;
        public Node prev;
    }
    
    public Stack2()
    {
        top = null;
        bottom = null;
        length = 0;
    }
    
    public int size()
    {
        return length;
    }
    
    public boolean isEmpty()
    {
        return length == 0;
    }
    
    public void push(E data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        if (isEmpty())
        {
            newNode.prev = null;
            top = newNode;
            bottom = newNode;
        }
        else
        {
            newNode.prev = top;
            top.next = newNode;
            top = newNode;
        }
        length++;
    }
    
    public E getTop() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("The stack is not empty");
        }
        return top.data;
    }
    
    public E pop() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("The stack is empty.");
        }
        E data = top.data;
        if (length == 1)
        {
            top = null;
            bottom = null;
        }
        else
        {
            top = top.prev;
            top.next = null;
        }
        length--;
        return data;
    }

    /**
     * Moves the top node of the stack to its bottom or does nothing
     * if the stack contains less than two elements.
     */
    public void moveTopNodeToBottom()
    {
        if (length >= 2)
        {
            Node node = top;
            top = top.prev;
            node.prev = null;
            node.next = bottom;
            bottom.prev = node;
            bottom = node;
        }
    }

    
    /**
     * Moves the bottom node of the stack to its top or does nothing
     * if the stack contains less than two elements.
     */
    public void moveBottomNodeToTop()
    {
        if (length >= 2)
        {
            Node node = bottom;
            bottom = bottom.next;
            node.next = null;
            node.prev = top;
            top.next = node;
            top = node;
        }
    }

    
    public String toString()
    {
        String string = "[";
        if(length > 0)
        {
            Node node = bottom;
            string = string + node.data;
            while(node != top)
            {
                node = node.next;
                string = string + ", " + node.data;
            }
        }
        string = string + "]";
        return string;
    }    
}
