package collections_framework.list_interface;

import java.util.ArrayList;
import java.util.List;


class ofMethod {

    // returns unmodifiable list
    // preserves the order in which elements are passed.

    public static void main(String[] args) {

        List<String> stringListA = List.of("A", "B", "C");
        System.out.println(stringListA.getClass().getName());
        System.out.println(stringListA);

        List<Integer> integerListA = new ArrayList<>();
        integerListA.add(1);
        List<Integer> integerListB = new ArrayList<>();
        integerListB.add(11);
        integerListB.add(12);

        List<List<Integer>> integerListList = List.of(integerListA, integerListB); // unmodifiable, mutable
        //integerListList.add(new ArrayList<>()); // UnsupportedOperationException

        System.out.println(integerListList);
        integerListList.getFirst().add(2); // mutability
        System.out.println(integerListList);

        String[] array = new String[3];
        array[0] = "A";
        array[1] = "B";
        array[2] = "C";

        List<String[]> arrayListA = List.<String[]>of(array); // static <E> List<E> of(E e1)
        List<String> arrayListB = List.of(array); // static <E> List<E> of(E... elements)
    }
}

// static <E> List<E> copyOf(Collection<? extends E> coll)
class copyOfMethod {

    // returns an unmodifiable list containing the elements of the given Collection, in its iteration order.
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        List<String> copyOfStringList = List.copyOf(stringList); // immutable

        System.out.println(copyOfStringList.getClass().getName());

        System.out.println(copyOfStringList);
        stringList.add("D"); // returned List will not reflect modifications
        System.out.println(copyOfStringList);
        System.out.println(stringList);

        List<Integer> integerListA = new ArrayList<>();
        integerListA.add(1);
        List<Integer> integerListB = new ArrayList<>();
        integerListB.add(1);
        integerListB.add(2);
        List<List<Integer>> integerListList = new ArrayList<>();
        integerListList.add(integerListA);
        integerListList.add(integerListB);
        List<List<Integer>> copyOfIntegerListList = List.copyOf(integerListList); // unmodifiable, mutable

        //copyOfIntegerListList.add(new ArrayList<>()); // UnsupportedOperationException

        System.out.println(copyOfIntegerListList);
        integerListA.add(2); // mutability
        System.out.println(copyOfIntegerListList);

        List<String> unmodifiableList = List.of("X", "Y", "Z");
        List<String> unmodifiableListCopy = List.copyOf(unmodifiableList); // no copy for unmodifiable list
        System.out.println( unmodifiableList == unmodifiableListCopy);
    }
}

public class Methods {
    public static void main(String[] args) {
    }
}
