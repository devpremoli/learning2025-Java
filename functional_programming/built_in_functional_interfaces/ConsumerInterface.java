package functional_programming.built_in_functional_interfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConsumerInterface {

    public static void main(String[] args) {

        // Consumer
        Consumer<String> printConsumer = (s) -> System.out.println("Hello, " + s);
        printConsumer.accept("Alice");
        // andThen()
        Consumer<String> toUpperCase = (s) -> System.out.println(s.toUpperCase());
        Consumer<String> addExclamation = (s) -> System.out.println(s + "!!!");
        Consumer<String> combinedConsumer = toUpperCase.andThen(addExclamation);
        combinedConsumer.accept("Hello");


        // Function
        Function<String, Integer> stringLength = String::length;
        System.out.println(stringLength.apply("Java"));
        Function<Integer, Integer> multiplyByTwo = (n) -> n * 2;
        Function<Integer, Integer> addTen = (n) -> n + 10;
        // andThen()
        Function<Integer, Integer> multiplyThenAdd = multiplyByTwo.andThen(addTen);
        System.out.println(multiplyThenAdd.apply(5)); // (5*2) + 10 = 20
        // compose()
        Function<Integer, Integer> addThenMultiply = multiplyByTwo.compose(addTen);
        System.out.println(addThenMultiply.apply(5)); // (5+10) * 2 = 30


        // Predicate
        Predicate<Integer> isEven = (num) -> num % 2 == 0;
        Predicate<Integer> isGreaterThan10 = (n) -> n > 10;
        System.out.println(isEven.test(4)); // Output: true
        System.out.println(isEven.test(7)); // Output: false
        // and()
        Predicate<Integer> isEvenAndGreaterThan10 = isEven.and(isGreaterThan10);
        System.out.println(isEvenAndGreaterThan10.test(12)); // Output: true
        System.out.println(isEvenAndGreaterThan10.test(7));  // Output: false
        // or()
        Predicate<Integer> isEvenOrGreaterThan10 = isEven.or(isGreaterThan10);
        System.out.println(isEvenOrGreaterThan10.test(13)); // Output: true
        // negate()
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println(isOdd.test(5));
        Predicate<String> isHello = Predicate.isEqual("Hello");
        System.out.println(isHello.test("Hello")); // Output: true
        // isEqual()
        List<String> words = List.of("Java", "Python", "Hello", "Java", "C++");
        List<String> javaWords = words.stream()
                .filter(Predicate.isEqual("Java"))
                .toList();
        System.out.println(javaWords);

    }
}
