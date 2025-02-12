package functional_programming;

import java.util.function.Function;

@FunctionalInterface
interface MyFunction {
    int apply(int x);
}

class SquareFunction implements MyFunction {
    @Override
    public int apply(int x) {
        return x * x;
    }
}

public class FirstClassCitizen {
    public static void main(String[] args) {

        // Function is wrapped inside an instance of a class that implements functional interface
        MyFunction squareNamedClass = new SquareFunction();
        System.out.println(squareNamedClass.apply(5));
        System.out.println("squareNamedClass: " + squareNamedClass.getClass());

        // Function is wrapped inside an instance of anonymous class that implements functional interface
        MyFunction squareAnonymousClass = new MyFunction() {
            @Override
            public int apply(int x) {
                return x * x;
            }
        };
        System.out.println(squareAnonymousClass.apply(5));
        System.out.println("squareAnonymousClass: " + squareAnonymousClass.getClass());

        // lambda expression is wrapped internally
        Function<Integer, Integer> squareLambda = x -> x * x;
        System.out.println(squareLambda.apply(5));
        System.out.println("squareLambda: " + squareLambda.getClass());
    }
}
