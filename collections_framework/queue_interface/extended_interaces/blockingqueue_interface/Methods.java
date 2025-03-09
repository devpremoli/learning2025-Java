package collections_framework.queue_interface.extended_interaces.blockingqueue_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


/*
void put(E e) throws InterruptedException
-> Inserts element; blocks if full
 */
class PutMethod {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer: started");
                queue.put(1);
                System.out.println("Producer: Added 1");
                queue.put(2);
                System.out.println("Producer: Added 2");

                System.out.println("Producer: Waiting...");
                queue.put(3); // BLOCKS until space is available
                Thread.sleep(5); // Ensures consumer takes 1 and 2 before producer starts adding
                System.out.println("Producer: Added 3");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(1); // Ensures producer starts first
                System.out.println("Consumer: started");
                int taken = queue.take();
                System.out.println("Consumer: Took " + taken);
                taken = queue.take();
                System.out.println("Consumer: Took " + taken);
                System.out.println("Consumer: Waiting...");
                Thread.sleep(10); // Ensures producer adds 3 before consumer starts taking
                System.out.println("Consumer: Taking " + queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();
    }
}


/*
E take() throws InterruptedException
-> Retrieves and removes element; blocks if empty
 */
class TakeMethod {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2); // Bounded queue

        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumer: started");
                System.out.println("Consumer: Waiting...");
                int value = queue.take(); // BLOCKS here until an element is available
                System.out.println("Consumer: Took " + value);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(1); // Ensures consumer starts first
                System.out.println("Producer: started");
                queue.put(1);
                System.out.println("Producer: Added 1");
                queue.put(2);
                System.out.println("Producer: Added 2");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        consumer.start();
        producer.start();
    }
}


/*
int remainingCapacity()
-> Returns the number of additional elements that the queue can accept at that moment without blocking.
-> For unbounded queues, it returns Integer.MAX_VALUE (but memory is still a limitation).
-> does not lock the queue or prevent other threads from modifying it. Other threads might insert or remove
 elements immediately after calling the remainingCapacity(), making the returned value outdated.
 */
class RemainingCapacityMethod {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        System.out.println("Initial Remaining Capacity: " + queue.remainingCapacity());

        try {
            queue.put(1);
            System.out.println("After adding 1: " + queue.remainingCapacity());

            queue.put(2);
            System.out.println("After adding 2: " + queue.remainingCapacity());

            queue.put(3);
            System.out.println("After adding 3: " + queue.remainingCapacity());

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


/*
int drainTo(Collection<? super E> c)
-> Removes all available elements from the queue and adds them to the given collection.
int drainTo(Collection<? super E> c, int maxElements)
-> Removes at most maxElements number of elements from the queue and adds them to the given collection.

-> Locks the queue once and moves all elements at once.
-> If an exception occurs, some elements may be in the queue, some in the collection, and some lost.
-> The behavior of this operation is undefined if the specified collection is modified while the operation
 is in progress.
 -> Attempts to drain a queue to itself result in IllegalArgumentException
 */
class DrainTo {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        try {
            // Adding elements to queue
            queue.put(1);
            queue.put(2);
            queue.put(3);
            queue.put(4);
            queue.put(5);

            System.out.println("Queue before drainTo: " + queue);

            List<Integer> list = new ArrayList<>();
            queue.drainTo(list); // Moves all elements from queue to list

            System.out.println("Queue after drainTo: " + queue);
            System.out.println("Elements moved to list: " + list);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


/*
boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException
-> Inserts the element into the queue; Returns true if added successfully, otherwise false after timeout.
 */
class OfferMethod {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer: started");
                queue.put(1);
                System.out.println("Producer: Added 1");
                queue.put(2);
                System.out.println("Producer: Added 2");
                TimeUnit timeUnit = TimeUnit.SECONDS;
                long timeout = 1;
                System.out.println("Producer: Trying to add 3, will wait for " + timeout + " " + timeUnit);

                Thread.sleep(3000);
                boolean added = queue.offer(3, timeout, timeUnit);

                if (added) {
                    System.out.println("Producer: Successfully added 3");
                } else {
                    System.out.println("Producer: Failed to add 3 after timeout");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(1000); // Consumer starts after this milliseconds
                System.out.println("Consumer: started");
                System.out.println("Consumer: Taking " + queue.take());
                System.out.println("Consumer: Taking " + queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();
    }
}

public class Methods {

    public static void main(String[] args) {
    }
}
