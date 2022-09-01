package circularqueue;

public interface CircularQueueInterface<E>
{
    public int size();
    public boolean isEmpty();
    public void enqueue(E data);
    public E front() throws Exception;
    public E dequeue() throws Exception;
}