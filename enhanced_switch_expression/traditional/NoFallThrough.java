package enhanced_switch_expression.traditional;

public class NoFallThrough {
    public static void main(String[] args) {
        int day = 2;
        String result;

        // Requires `break;` to avoid fall-through
        switch (day) {
            case 1:
                result = "Monday";
                break;
            case 2:
                result = "Tuesday";
                break;
            case 3:
                result = "Wednesday";
                break;
            default:
                result = "Invalid day";
        }

        System.out.println(result); // Output: Tuesday
    }
}
