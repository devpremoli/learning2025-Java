package functional_programming.built_in_functional_interfaces;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceContext {
    public static void main(String[] args) {

        // Assignment Context
        Function<String, Integer> stringLength = String::length;
        System.out.println(stringLength.apply("Java")); // Output: 4

        // Method invocation context
        printLength(String::length);

        // Casting context
        Function<String, Integer> obj = (Function<String, Integer>) (String::length);
        System.out.println(obj.apply("Casting")); // Output: 7

        Predicate<String> newObj = (Predicate<String>) (String::isEmpty);
        System.out.println(newObj.test(""));
    }
    static void printLength(Function<String, Integer> function) {
        System.out.println("Length: " + function.apply("Hello"));
    }
}
