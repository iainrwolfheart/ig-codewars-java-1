public class DescendingOrder {

    public static void main(String[] args) {
//        System.out.println("Expected: " + 0 +
//                ", actual: " + sortDesc(0));
//
//        System.out.println("Expected: " + 51 +
//                ", actual: " + sortDesc(15));
//
//        System.out.println("Expected: " + 987654321 +
//                ", actual: " + sortDesc(123456789));

        int factorialOf = 6;
        System.out.println("Factorial of " + factorialOf +
                " is " + findFactorial(factorialOf));
    }

    public static int sortDesc(final int num) {
        int i, j, swap;
        int result = 0;
        String stringArr = Integer.toString(num);
        int[] intArr = new int[stringArr.length()];

        for (i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.valueOf(stringArr.substring(i, i +1));
        }

        for (i = 0; i < intArr.length - 1; i++) {
            int max = i;
            for (j = i + 1; j < intArr.length; j++) {
                if (intArr[j] > intArr[max]) {
                    max = j;
                }
            }
            if (max != i) {
                swap = intArr[i];
                intArr[i] = intArr[max];
                intArr[max] = swap;
            }
        }

        for (int number : intArr) {
            result = 10 * result + number;
        }

        return result;
    }

    public static int findFactorial(int n) {
        if (n == 0) return 1;
        else return n * findFactorial(n-1);
    }
}