package sealed_class.abc_demo;

public class Main {
    public static void main(String[] args) {}
}

/*
Sealed
- A special type of class or interface that restricts which other classes or interfaces can extend or implement it.
- Used to create a well-defined hierarchy by controlling inheritance through explicitly defining allowed subclasses or implementors.
- Any subclass of a sealed class or interface must be declared as `final`, `sealed`, or `non-sealed`.
- Helps in pattern matching, making `switch` expressions exhaustive and reducing the need for a default case.
 */


/*
Resources
https://www.baeldung.com/java-sealed-classes-interfaces

 */