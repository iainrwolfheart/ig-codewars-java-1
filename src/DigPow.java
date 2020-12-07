import java.util.ArrayList;

public class DigPow {
//    public static void main(String[] args) {
//        System.out.println("Expected: " + 1 + ". Output: " + digPow(89, 1));
//
//        System.out.println("Expected: " + -1 + ". Output: " + DigPow.digPow(92, 1));
//
//        System.out.println("Expected: " + 51 + ". Output: " + DigPow.digPow(46288, 3));
//    }

    public static long digPow(int n, int p) {
        ArrayList<Double> numbers = new ArrayList<>();
        int base = n;
        int sum = 0;

        while (n > 0) {
            numbers.add(0,n % 10.0);
            n /= 10;
        }

        for (int i = 0; i < numbers.size(); i++, p++) {
            sum += Math.pow(numbers.get(i), p);
        }

        if (sum % base == 0) return sum / base;

        return -1;
    }


}