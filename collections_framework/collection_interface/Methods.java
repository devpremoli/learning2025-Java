package collections_framework.collection_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Methods {

    public static void main(String[] args) {

        Collection<Integer> collectionIntegerA = new ArrayList<>(List.of(10, 20, 30));

        // Object[] toArray()
        /*
        - returned array's runtime component type is Object.
        - always allocates a new array, even if the collection is backed by an array
        - maintains the order in which elements are returned by the collection's iterator
         */
        System.out.println("Object[] toArray()");
        Object[] collectionIntegerAObjectArray = collectionIntegerA.toArray();
        System.out.println(Arrays.toString(collectionIntegerAObjectArray));


        /*
        <T> T[] toArray(T[] a)
        - runtime type of the returned array is that of the specified array
        - does not accept a primitive type array
        - if the size of the provided array is small, new array is created
        - maintains the order in which elements are returned by the collection's iterator
         */
        System.out.println("\n<T> T[] toArray(T[] a)");
        Integer[] tempArray = new Integer[0];
        Integer[] collectionIntegerAIntArrayA = collectionIntegerA.toArray(tempArray);
        System.out.println(collectionIntegerAIntArrayA == tempArray);
        System.out.println(Arrays.toString(collectionIntegerAIntArrayA));

        tempArray = new Integer[collectionIntegerA.size()];
        Integer[] collectionIntegerAIntArrayB = collectionIntegerA.toArray(tempArray);
        System.out.println(collectionIntegerAIntArrayB == tempArray);
        System.out.println(Arrays.toString(collectionIntegerAIntArrayB));

        tempArray = new Integer[collectionIntegerA.size() + 1];
        Integer[] collectionIntegerAIntArrayC = collectionIntegerA.toArray(tempArray);
        System.out.println(collectionIntegerAIntArrayC == tempArray);
        System.out.println(Arrays.toString(collectionIntegerAIntArrayC));


        // default <T> T[] toArray(IntFunction<T[]> generator)
//        Integer[] collectionIntegerAIntArrayB = collectionIntegerA.toArray(Integer[]::new);
//        System.out.println(Arrays.toString(collectionIntegerAIntArrayB));




    }
}
