package enhanced_switch_expression.traditional;

public class MultiCaseSwitch {
    public static void main(String[] args) {
        String fruit = "Apple";
        String type;

        // ✅ Traditional switch with fall-through behavior
        switch (fruit) {
            case "Apple":
            case "Banana":
            case "Mango":
                type = "Fruit";
                break;
            case "Carrot":
            case "Broccoli":
                type = "Vegetable";
                break;
            default:
                type = "Unknown";
        }

        System.out.println(type); // Output: Fruit
    }
}
