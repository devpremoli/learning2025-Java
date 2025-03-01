package enhanced_switch_expression;

public class Main {

    public static void main(String[] args) {

        int day = 2;
        // No need for break; each case executes only its block
        String result = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Invalid day";
        };
        System.out.println(result); // Output: Tuesday



        String fruit = "Apple";
        // Multiple labels in a single case (No need for fall-through)
        String type = switch (fruit) {
            case "Apple", "Banana", "Mango" -> "Fruit";
            case "Carrot", "Broccoli" -> "Vegetable";
            default -> "Unknown";
        };
        System.out.println(type); // Output: Fruit


        int month = 3;
        // Assign result directly using switch expression
        int days = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> throw new IllegalArgumentException("Invalid month");
        };
        System.out.println(days); // Output: 31
    }
}

/*
Enhanced Switch Expression
- No Fall-Through Behavior → Eliminates the need for `break` statements. Uses `->` syntax for clarity.
- Can Return Values → `switch` can be used as an expression, directly assigning results to variables.
- Supports Multiple Labels → Allows grouping cases using `,` (e.g., `case A, B ->`).
- More Readable & Concise → Reduces boilerplate code compared to traditional `switch`.
- Works with Pattern Matching → Seamlessly integrates with records and sealed classes. (Java 21)
*/

/*
- In traditional switch statements, fall-through behavior occurs when a case does not have a
break; statement, causing execution to continue into the next case block, even if it doesn't match.
 */
