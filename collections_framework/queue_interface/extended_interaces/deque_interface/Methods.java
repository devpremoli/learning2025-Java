package collections_framework.queue_interface.extended_interaces.deque_interface;

import java.util.ArrayDeque;
import java.util.Deque;

/*
public class ArrayDeque<E>
extends AbstractCollection<E>
implements Deque<E>, Cloneable, Serializable
 */
public class Methods {
    public static void main(String[] args) {

        Deque<Integer> dequeA = new ArrayDeque<>();
        dequeA.add(5);
        dequeA.add(6);
        dequeA.add(7);

        // public void addFirst(E e)
        dequeA.addFirst(4);
        // public void addLast(E e)
        dequeA.addLast(8);
        // public boolean offerFirst(E e)
        dequeA.offerFirst(3);
        // boolean offerLast(E e)
        dequeA.offerLast(9);

        System.out.println(dequeA);
        // E removeFirst()
        System.out.println(dequeA.removeFirst());
        // E removeLast()
        System.out.println(dequeA.removeLast());
        // E pollFirst()
        System.out.println(dequeA.pollFirst());
        // E pollLast()
        System.out.println(dequeA.pollLast());

        System.out.println(dequeA);
        // E getFirst()
        System.out.println(dequeA.getFirst()); // NoSuchElementException - if this deque is empty
        // E getLast()
        System.out.println(dequeA.getLast());
        // E peekFirst()
        System.out.println(dequeA.peekFirst());
        // E peekLast()
        System.out.println(dequeA.peekLast());

        // void push(E e)
        dequeA.push(10); // at the head
        // E pop()
        System.out.println(dequeA.pop()); // removes and returns the first element
    }
}
