package collections_framework.collection_interface;


import java.util.*;
import java.util.stream.Stream;

/*
public interface Collection<E>
extends Iterable<E>

https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/Collection.html

 */

public class CollectionInterfaceMethods {

    public static void main(String[] args) {

        Collection<String> arrayListA = new ArrayList<>();

        // boolean add(E e)
        arrayListA.add("Apple");
        arrayListA.add("Banana");
        arrayListA.add("Cherry");
        arrayListA.add("Mango");
        System.out.println("add: " + arrayListA);

        // boolean addAll(Collection<? extends E> c)
        Collection<String> moreFruits = Arrays.asList("Dates", "Elderberry");
        arrayListA.addAll(moreFruits);
        System.out.println("addAll: " + arrayListA);

        // void clear()
        Collection<String> arrayListB = new ArrayList<>(arrayListA);
        arrayListB.clear();
        System.out.println("clear: " + arrayListB);

        // boolean contains(Object o)
        System.out.println("contains: " + arrayListA.contains("Banana"));

        // boolean containsAll(Collection<?> c)
        System.out.println("containsAll: " + arrayListA.containsAll(Arrays.asList("Apple", "Cherry")));

        // boolean equals(Object o)
        Collection<String> arrayListC = new ArrayList<>(arrayListA);
        System.out.println("equals: " + arrayListA.equals(arrayListC));

        // int hashCode()
        System.out.println("hasCode: " + arrayListA.hashCode());

        // boolean isEmpty()
        System.out.println("isEmpty: " + arrayListA.isEmpty());

        // Iterator<E> iterator()
        Iterator<String> iterator = arrayListA.iterator();
        System.out.print("iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // default Stream<E> parallelStream()
        Stream<String> parallelStream = arrayListA.parallelStream();
        System.out.print("Parallel Stream: ");
        parallelStream.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // boolean remove(Object o)
        arrayListA.remove("Apple");
        System.out.println("remove: " + arrayListA);

        // boolean removeAll(Collection<?> c)
        arrayListA.removeAll(Arrays.asList("Banana", "Cherry"));
        System.out.println("removeAll: " + arrayListA);

        // default boolean removeIf(Predicate<? super E> filter)
        arrayListA.removeIf(s -> s.startsWith("D"));
        System.out.println("removeIf: " + arrayListA);

        // boolean retainAll(Collection<?> c)
        arrayListA.retainAll(Arrays.asList("Elderberry", "Mango"));
        System.out.println("retainAll: " + arrayListA);

        // int size()
        System.out.println("Size: " + arrayListA.size());


        // spliterator()
        Spliterator<String> spliterator = arrayListA.spliterator();
        System.out.print("spliterator: ");
        spliterator.forEachRemaining(System.out::println);

        // stream()
        Stream<String> stream = arrayListA.stream();
        System.out.print("stream: ");
        stream.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // toArray()
        Object[] array = arrayListA.toArray();
        System.out.println("toArray(): " + Arrays.toString(array));

        // toArray(T[] a)
        String[] strArray = arrayListA.toArray(new String[0]);
        System.out.println("toArray(T[] a): " + Arrays.toString(strArray));

        // toArray(IntFunction<T[]> generator)
        String[] generatedArray = arrayListA.toArray(String[]::new);
        System.out.println("toArray(IntFunction<T[]> generator): " + Arrays.toString(generatedArray));
    }
}
