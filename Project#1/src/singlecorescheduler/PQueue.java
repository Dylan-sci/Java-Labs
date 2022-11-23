package singlecorescheduler;


import java.util.*;

/**
 * This class models a priority min-queue that uses an array-list-based min binary heap 
 * that implements the PQueueAPI interface. The array holds objects that implement the 
 * parameterized Comparable interface.
 * @author William Duncan, Dylan Scivicque
 * @param <E> the priority queue element type. 
 * <pre>
 * Date: 9/21/2022
 * Course: csc 3102
 * Programming Project # 1
 * Instructor: Dr. Duncan
 * </pre>
 */
public class PQueue<E extends Comparable<E>> implements PQueueAPI<E>
{    
   /**
    * A complete tree stored in an array list representing the 
    * binary heap
    */
   private ArrayList<E> tree;
   /**
    * A comparator lambda function that compares two elements of this
    * heap when rebuilding it; cmp.compare(x,y) gives 1. negative when x less than y
    * 2. positive when x greater than y 3. 0 when x equal y
    */   
   private Comparator<? super E> cmp;
   
   /**
    * Constructs an empty PQueue using the compareTo method of its data type as the 
	* comparator
    */
   public PQueue()
   {
       tree = new ArrayList<>();
       PriorityQueue<E> pQueue = new PriorityQueue<>((x,y) -> { return x.compareTo(y); });
   }
   
   /**
    * A parameterized constructor that uses an externally defined comparator    
    * @param fn - a trichotomous integer value comparator function   
    */
   public PQueue(Comparator<? super E> fn)
   {
       tree = new ArrayList<>();
       cmp = fn;
   }

   public boolean isEmpty()
   {
       if (size() == 0)
       {
           return true;
       }
       else 
       {
           return false;
       }
   }

   public void insert(E obj)
   {
       tree.add(obj);
       int place = size() - 1;
       int parent = (place - 1 ) / 2;
       while (parent >= 0 && tree.get(place).compareTo(tree.get(parent)) > 0)
       {
           swap(place, parent);
           place = parent;
           parent = (place - 1) / 2;
       }
   }

   public E remove() throws PQueueException
   {
       if (!tree.isEmpty())
       {
           E root = tree.get(0);
           tree.set(0, tree.get(size() - 1));
           rebuild(0, size());
           return root;
       }
       else
       {
           return null;
       }
   }
 
   public E peek() throws PQueueException
   {
       if (!tree.isEmpty())
       {
           return tree.get(0);
       }
       else
       {
           return null;
       }
   }

   public int size()
   {
       if (!tree.isEmpty())
       {
           return tree.size();
       }
       else
       {
           return 0;
       }
   }
   
   /**
    * Swaps a parent and child elements of this heap at the specified indices
    * @param place an index of the child element on this heap
    * @param parent an index of the parent element on this heap
    */
   private void swap(int place, int parent)
   {
       E temp = tree.get(place);
       tree.set(place, tree.get(parent));
       tree.set(parent, temp);
   }

   /**
    * Rebuilds the heap to ensure that the heap property of the tree is preserved.
    * @param root the root index of the subtree to be rebuilt
    * @param eSize the size of this tree
    */
   private void rebuild(int root, int eSize)
   {
       if (2 * root > eSize && 2 * root + 1 > eSize)
       {
           int child = 2 * root + 1;
           if (root * 2 + 1 <= eSize)
           {
               if (tree.get(child + 1).compareTo(tree.get(child)) > 0)
               {
                   child = child + 1;
               }
               if (tree.get(root).compareTo(tree.get(child)) < 0)
                   
               {
                   swap(root, child); 
                   rebuild(child, eSize);
               }
            }
        }
    }
   
}
