import java.util.ArrayList;

public class DirectionsReductionFiveKyu {

    public static void main(String[] args) {

        System.out.println("Expect: \"WEST\". Actual: " + dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}).toString());
//        System.out.println("Expect: []. Actual: " + dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));

    }

    public static String[] dirReduc(String[] arr) {
        ArrayList<String> ns = new ArrayList<>();
        ns.add("NORTH");
        ns.add("SOUTH");
        ArrayList<String> ew = new ArrayList<>();
        ew.add("EAST");
        ew.add("WEST");
        ArrayList<String> outputList = new ArrayList<>();

        for(int i = 1; i <= arr.length - 1; i++) {
            ArrayList<String> tempArr = new ArrayList<>();
            tempArr.add(arr[i]);
            tempArr.add(arr[i - 1]);

            if (tempArr.containsAll(ns) || tempArr.containsAll(ew)) {
                i++;
            } else outputList.add(arr[i]);
        }
        System.out.println("Output = " + outputList);

        return arr;
    }
}
