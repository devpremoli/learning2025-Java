package collections_framework.list_interface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnmodifiableList {

    public static void main(String[] args) {


        Map<List<String>, String> cache = new HashMap<>();
        List<String> keyA = List.of("A", "B");
        List<String> keyB = List.of("A", "B");
        System.out.println(keyA.equals(keyB));
        System.out.println(keyA == keyB); // May be true or false (depends on Java optimizations)
        cache.put(keyA, "CachedValue");

        System.out.println("cache contains keyB? " + cache.containsKey(keyB)); // interchangeable
        System.out.println("Retrieved value: " + cache.get(keyB)); // interchangeable


        /*
        Callers should make no assumptions about the identity of the returned instances. Factories are free
         to create new instances or reuse existing ones.
         */
        List<String> listA = List.of("A", "B");
        List<String> listB = List.of("A", "B");

        System.out.println(listA == listB); // May be true or false (depends on Java optimizations)

    }
}
