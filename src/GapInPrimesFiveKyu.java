import java.util.ArrayDeque;
import java.util.Arrays;

class GapInPrimes {

    public static void main(String[] args) {
        System.out.println("EXPECTED: [101, 103], ACTUAL: " + Arrays.toString(gap(2,100,110)));
        System.out.println("EXPECTED: [103, 107], ACTUAL: " + Arrays.toString(gap(4,100,110)));
        System.out.println("EXPECTED: null, ACTUAL: " + Arrays.toString(gap(6,100,110)));
        System.out.println("EXPECTED: [359, 367], ACTUAL: " + Arrays.toString(gap(8,300,400)));
        System.out.println("EXPECTED: [337, 347], ACTUAL: " + Arrays.toString(gap(10,300,400)));
    }

    public static long[] gap(int g, long m, long n) {

        long[] longArr = new long[2];
        ArrayDeque<Long> longDeque = new ArrayDeque<>(2);
        while (m <= n) {
            if(isPrime(m)) {
                if (longDeque.size() < 2) longDeque.addLast(m);
                else {
                    if (longDeque.getLast() - longDeque.getFirst() == g) {
                        longArr[0] = longDeque.getFirst();
                        longArr[1] = longDeque.getLast();
                        return longArr;
                    } else {
                        longDeque.removeFirst();
                        longDeque.addLast(m);
                    }
                }
            }
            m++;
        }
        return null;
    }

    public static boolean isPrime(long m) {
        //check if n is a multiple of 2
        if (m%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=m;i+=2) {
            if(m%i==0)
                return false;
        }
        return true;
    }
}