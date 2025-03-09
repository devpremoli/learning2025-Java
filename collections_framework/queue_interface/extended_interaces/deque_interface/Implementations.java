package collections_framework.queue_interface.extended_interaces.deque_interface;


import java.util.ArrayDeque;
import java.util.Deque;

public class Implementations {
    public static void main(String[] args) {

        Deque<Integer> arrayDeque = new ArrayDeque<>();

        System.out.println(arrayDeque.add(1)); // at the end
        System.out.println(arrayDeque.add(2));
        System.out.println(arrayDeque.offer(3));
        System.out.println(arrayDeque.poll()); // from the beginning
        System.out.println(arrayDeque);
    }
}
