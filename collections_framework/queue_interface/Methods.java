package collections_framework.queue_interface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/*
public interface Queue<E> extends Collection<E>
 */
public class Methods {

    public static void main(String[] args) {

        Queue<Integer> queueA = new ArrayBlockingQueue<>(3);

        /*
        boolean add(E e)
        -> Inserts element into the queueA; throws IllegalStateException if full
         */
        System.out.println(queueA.add(1));
        queueA.add(2);
        queueA.add(3);
        //queueA.add(4); // IllegalStateException


        /*
        boolean offer(E e)
        -> Inserts element into the queueA; returns false if full
         */
        System.out.println(queueA.offer(5));


        /*
        E remove()
        -> Removes and returns the head of the queueA; throws NoSuchElementException if empty
         */
        Queue<Integer> queueB = new LinkedList<>();
        // queueB.remove();
        queueB.add(1);
        queueB.add(2);
        System.out.println(queueB.remove());


        /*
        E poll()
        -> Removes and returns the head of the queue; returns null if empty
         */
        queueB = new LinkedList<>();
        System.out.println(queueB.poll());


        /*
        E element()
        -> Retrieves head element without removing; throws NoSuchElementException if empty
         */
        //queueB.element();


        /*
        E peek()
        -> Retrieves head element without removing; returns null if empty
         */
        System.out.println(queueB.peek());
    }
}
