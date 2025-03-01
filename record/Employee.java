package record;



import java.util.List;

public record Employee(int id, String name, double salary, List<String> departments) {

    // Static fields
    public static int empCounter = 0;
    private static double totalSalary = 0;

    // Static block
    // -> Use to: initialize class-level resources, validate static fields
    static {
        System.out.println("Employee record initialized.");
        if (totalSalary < 0) {
            throw new IllegalArgumentException("totalSalary cannot be negative!");
        }
    }

    // Compact Constructor
    // -> declared without an explicit parameter list, implicitly receive all the record's components as arguments.
    // -> Use to: validate instance fields, update static fields, Prevent external modification of mutable objects
    public Employee {

        // validate instance field
        if (salary < 0) {
            throw new IllegalArgumentException("salary cannot be negative!");
        }

        // Defensive Copying to prevent modification of mutable list
        departments = List.copyOf(departments);

        // update static field
        empCounter++;
        totalSalary += salary;
    }

    // Parametrized Constructor
    public Employee(int id) {
        this(id, "No Name", 0.0, List.of());
    }

    public static double getTotalSalary() {
        return totalSalary;
    }
}

