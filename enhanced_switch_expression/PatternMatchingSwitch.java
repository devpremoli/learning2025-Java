package enhanced_switch_expression;

// ✅ Sealed Interface
sealed interface Shape permits Circle, Rectangle {}

record Circle(double radius) implements Shape {}
record Rectangle(double length, double width) implements Shape {}

public class PatternMatchingSwitch {
    public static void main(String[] args) {
        Shape shape = new Circle(5);

        // ✅ Uses pattern matching inside switch
        String result = switch (shape) {
            case Circle c -> "Circle with radius " + c.radius();
            case Rectangle r -> "Rectangle with length " + r.length() + " and width " + r.width();
        };

        System.out.println(result); // Output: Circle with radius 5.0
    }
}
