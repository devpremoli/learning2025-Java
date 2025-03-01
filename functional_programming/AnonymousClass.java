package functional_programming;
import java.util.function.Function;

interface Greeting {
    void sayHello();
}

class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

public class AnonymousClass {

    public static void main(String[] args) {

        // implements Interface
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello from an anonymous class!");
            }
        };
        greeting.sayHello();

        // extends class
        Animal dog = new Animal() {
            @Override
            void makeSound() {
                System.out.println("Dog barks");
            }
        };
        dog.makeSound();

        // Before Java 8
        Function<Integer, Integer> square = new Function<>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        System.out.println(square.apply(5));

        // Java 8+
        Function<Integer, Integer> newSquare = x -> x * x; // lambda expression
        System.out.println(newSquare.apply(5));

        Function<Integer, Integer> squareMethodRef = AnonymousClass::squareMethod; // method reference
        System.out.println(squareMethodRef.apply(5));

        // String::length is equivalent to str -> str.length()
        Function<String, Integer> lengthLambda = str -> str.length();
        Function<String, Integer> lengthMethodRef = String::length;
        System.out.println(lengthLambda.apply("Hello"));
        System.out.println(lengthMethodRef.apply("Hello"));

    }
    public static Integer squareMethod(Integer x) {
        return x * x;
    }
}
