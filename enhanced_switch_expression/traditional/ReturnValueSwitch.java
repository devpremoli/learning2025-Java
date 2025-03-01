package enhanced_switch_expression.traditional;


public class ReturnValueSwitch {
    public static void main(String[] args) {
        int month = 3;
        int days;

        // Cannot return values directly; must use a temporary variable
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                days = 28;
                break;
            default:
                throw new IllegalArgumentException("Invalid month");
        }

        System.out.println(days); // Output: 31
    }
}
