package interfaces;

interface MyInterface {
    // Constant (implicitly public, static, final)
    int CONSTANT_VALUE = 100;

    // Abstract method (must be implemented by a class)
    void abstractMethod();

    // Default method (provides a default implementation)
    default void defaultMethod() {
        System.out.println("This is the default method.");
    }

    // Static method (belongs to the interface, cannot be overridden)
    static void staticMethod() {
        System.out.println("This is the static method.");
    }

    // Nested Interface
    interface NestedInterface {
        void nestedInterfaceMethod();
    }

    // Nested Class
    class NestedClass {
        void nestedClassMethod() {
            System.out.println("This is a method inside the nested class.");
        }
    }
}

// MyClass implements both MyInterface and the NestedInterface
public class MyClass implements MyInterface, MyInterface.NestedInterface {
    @Override
    public void abstractMethod() {
        System.out.println("Implementation of the abstract method in MyClass.");
    }

    @Override
    public void nestedInterfaceMethod() {
        System.out.println("Implementation of the nested interface method.");
    }
}

class Main {

    public static void main(String[] args) {
        System.out.println("=== Creating MyClass Instance ===");
        MyClass myClass = new MyClass();

        // Access constant from interface
        System.out.println("Constant Value: " + MyInterface.CONSTANT_VALUE);

        // Call static method from interface
        MyInterface.staticMethod();
        myClass.abstractMethod();
        myClass.defaultMethod();


        // Call nested interface method
        myClass.nestedInterfaceMethod();

        // Create instance of the nested class and call its method
        MyInterface.NestedClass nestedClass = new MyInterface.NestedClass();
        nestedClass.nestedClassMethod();

        System.out.println("\n=== Using MyInterface Reference ===");
        // Upcasting to MyInterface
        MyClass interClass = new MyClass();
        System.out.println("Constant Value: " + MyInterface.CONSTANT_VALUE);

        // Calling methods via interface reference
        interClass.abstractMethod();
        interClass.defaultMethod();
        MyInterface.staticMethod();

        // Casting to access methods from NestedInterface
        interClass.nestedInterfaceMethod();

        // Creating another nested class instance
        MyInterface.NestedClass interNestedClass = new MyInterface.NestedClass();
        interNestedClass.nestedClassMethod();
    }
}

