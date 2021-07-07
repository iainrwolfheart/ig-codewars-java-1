import java.util.Arrays;

public class MaximumSubArraySumFiveKyu {

    public static void main(String[] args) {
        System.out.println("Expected: 0. Actual: " + sequence(new int[]{}));
        System.out.println("Expected: 6. Actual: " + sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println("Expected: 5. Actual: " + sequence(new int[]{3, 2, 0, -4, -1, -2, 1, -5, 4}));

    }

    public static int sequence(int[] arr) {
        int finalMax = Arrays.stream(arr).sum();

        for (int i = 0; i < arr.length -1; i++) {
            int currentItr = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                currentItr += arr[j];
                if (currentItr > finalMax) {
                    finalMax = currentItr;
                }
            }
        }
        return finalMax >= 0 ? finalMax : 0;
    }
}
