import java.util.HashMap;

public class LooseChangeSixKyu {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Pennies", 4);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 1);
        System.out.print("EXPECTED: ");
        map.forEach((k, v) -> System.out.print(k + ": " + v + ", "));
        System.out.print("\nACTUAL: ");
        looseChange(29).forEach((k, v) -> System.out.print(k + ": " + v + ", "));
        System.out.println();

        map = new HashMap<>();
        map.put("Pennies", 0);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 0);
        System.out.print("\nEXPECTED: ");
        map.forEach((k, v) -> System.out.print(k + ": " + v + ", "));
        System.out.print("\nACTUAL: ");
        looseChange(0).forEach((k, v) -> System.out.print(k + ": " + v + ", "));
        System.out.println();

        map = new HashMap<>();
        map.put("Pennies", 1);
        map.put("Nickels", 1);
        map.put("Dimes", 1);
        map.put("Quarters", 3);
        System.out.print("\nEXPECTED: ");
        map.forEach((k, v) -> System.out.print(k + ": " + v + ", "));
        System.out.print("\nACTUAL: ");
        looseChange(91).forEach((k, v) -> System.out.print(k + ": " + v + ", "));
        System.out.println();

        map = new HashMap<>();
        map.put("Pennies", 0);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 0);
        System.out.print("\nEXPECTED: ");
        map.forEach((k, v) -> System.out.print(k + ": " + v + ", "));
        System.out.print("\nACTUAL: ");
        looseChange(-2).forEach((k, v) -> System.out.print(k + ": " + v + ", "));
    }

    public static HashMap<String, Integer> looseChange(int cent) {

        int nickels = 0, dimes = 0, quarters = 0;

        if (cent > 0) {
            quarters = cent / 25;
            cent %= 25;
            dimes = cent / 10;
            cent %= 10;
            nickels = cent / 5;
            cent %= 5;
        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Quarters", quarters);
        map.put("Dimes", dimes);
        map.put("Nickels", nickels);
        map.put("Pennies", cent <= 0 ? 0 : cent);

        return map;
    }
}


