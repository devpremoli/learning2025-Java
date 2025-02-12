package functional_programming;

import java.util.function.Function;

public class HigherOrderFunction {

    public static int takeFunction(int x, Function<Integer, Integer> func) {
        return func.apply(x);
    }

    public static Function<Integer, Integer> returnFunction(int factor) {
        return n -> n * factor;
    }


    public static void main(String[] args) {

        Function<Integer, Integer> square = n -> n * n;
        System.out.println("applyFunction(5, square): " + takeFunction(5, square));

        Function<Integer, Integer> triple = returnFunction(3);
        System.out.println("triple.apply(5): " + triple.apply(5));
    }
}
