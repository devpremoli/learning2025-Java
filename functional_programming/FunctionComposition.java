package functional_programming;

import java.util.function.Function;

public class FunctionComposition {
    public static void main(String[] args) {
        Function<Integer, Integer> cube = x -> x * x * x;
        Function<Integer, Integer> increment = x -> x + 1;

        Function<Integer, Integer> cubeThenIncrement = cube.andThen(increment);
        Function<Integer, Integer> incrementThenCube = cube.compose(increment);

        System.out.println("cubeThenIncrement.apply(2): " + cubeThenIncrement.apply(2));
        System.out.println("incrementThenCube.apply(2): " + incrementThenCube.apply(2));


        Function<String, String> trim = String::trim;
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> addExclamation = str -> str + "!";

        // Trim, then convert to uppercase, then add "!"
        Function<String, String> processString = trim.andThen(toUpperCase).andThen(addExclamation);

        System.out.println("processString.apply(\"  hello  \"): " + processString.apply("  hello  "));
    }
}