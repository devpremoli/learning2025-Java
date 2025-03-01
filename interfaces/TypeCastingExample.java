package interfaces;

interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Bark!");
    }

    public void wagTail() {
        System.out.println("Wagging tail...");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }

    public void scratch() {
        System.out.println("Scratching furniture...");
    }
}

public class TypeCastingExample {
    public static void main(String[] args) {

        // Compiler only knows that myAnimal is an instance of a class implementing Animal, but it does not know which exact class at compile time.
        // At runtime, Java determines that myAnimal is actually an instance of
        Animal myAnimal = new Dog();
        myAnimal.makeSound();

        // Incorrect cast: Compiler does not check this!
        // Cat cast = (Cat) myAnimal; // Runtime Error: ClassCastException
        Dog cast = (Dog) myAnimal;

        cast.makeSound();
    }
}

