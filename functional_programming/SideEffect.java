package functional_programming;

import java.util.ArrayList;
import java.util.List;

public class SideEffect {

    public static int add(int a, int b) { // pure function
        a = a * 2;
        b = b * 3;
        return a + b;
    }

    // If a function has no side effect but does not return a value, it has no observable effect, making it meaningless.
    public static void returnNothing(int a) { // impure function
        a = a * a;
    }

    // list is a local variable, but it points to an external object (which persists beyond the function's scope). So, addList is modifying an object that exists outside its local scope.
    public static List<Integer> addList( List<Integer> list) { // impure function
        list.add(10);
        return list;
    }

    public static List<Integer> reassignList( List<Integer> list) { // pure function
        list = new ArrayList<>(list); // now list references different memory location
        list.add(10);
        return list;
    }

    public static void main(String[] args) {

        int a = 5;
        int b = 10;
        int addResult = add(a, b);
        System.out.println("addResult: " + addResult);
        System.out.println("a: " + a + ", b: " + b);

        returnNothing(5);

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> addListResult = addList(numbers);
        System.out.println("addListResult: " + addListResult);
        System.out.println("numbers: " + numbers);

        numbers = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> reassignListResult = reassignList(numbers);
        System.out.println("reassignListResult: " + reassignListResult);
        System.out.println("numbers: " + numbers);
    }
}