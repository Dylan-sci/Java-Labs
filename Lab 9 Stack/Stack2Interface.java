package stack2;

public interface Stack2Interface<E> 
{
    public int size();
    public boolean isEmpty();
    public void push(E data);
    public E getTop() throws Exception;
    public E pop() throws Exception;    
}