public class SquareSum {

    public static void main(String[] args) {
        System.out.println("Expected 9. Actual: " + squareSum(new int[] {1,2,2}));
        System.out.println("Expected 5. Actual: " + squareSum(new int[] {1,2}));
        System.out.println("Expected 50. Actual: " + squareSum(new int[] {5,-3,4}));

    }

    public static int squareSum(int[] n) {

        int result = 0;

        for (int number : n) {
            result += number * number;
        }

        return result;
    }
}
