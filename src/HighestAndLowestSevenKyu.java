import java.util.ArrayList;
import java.util.Collections;

public class HighestAndLowestSevenKyu {

    public static void main(String[] args) {
        System.out.println("42 -9 | " + highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    public static String highAndLow(String numbers) {

        ArrayList<Integer> numList = new ArrayList<>();

        for(String num : numbers.split(" ")) {
            numList.add(Integer.parseInt(num));
        }

        Collections.sort(numList);

        return numList.get(numList.size() - 1) + " " + numList.get(0);
    }
}
