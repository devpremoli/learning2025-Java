package object_class.equals_method;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // If the object is compared with itself then return true
        // If both references are the same, they are equal (no need for further checks).
        if (this == obj) return true;

        // obj == null → Prevents NullPointerException
        // getClass() != obj.getClass() → Ensures obj is exactly a Person (prevents class mismatches).
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age); // Must be consistent with equals()
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class PersonExample {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Alice", 25);
        Person p3 = new Person("Alice", 25);
        Person p4 = new Person("Alice", 30);
        Person p5 = new Person("Bob", 30);

        // Reflexive
        System.out.println("Reflexive: " + p1.equals(p1));

        // Symmetric
        System.out.println("Symmetric: " + (p1.equals(p2) == p2.equals(p1)));

        // Transitive
        System.out.println("Transitive: " + (p1.equals(p2) && p2.equals(p3) && p1.equals(p3)));

        // Consistent
        System.out.println("Consistent: " + (p1.equals(p2) && p1.equals(p2)));

        // Non-null
        System.out.println("Non-null: " + p1.equals(null));
    }
}
