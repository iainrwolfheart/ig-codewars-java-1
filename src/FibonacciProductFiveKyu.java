public class FibonacciProductFiveKyu {

    public static void main(String[] args) {
        System.out.print("55, 89, 1 | ");
        long[] rtrndArr = productFib(4895);
        for(long ele : rtrndArr) {
            System.out.print(ele + ", ");
        }
        System.out.print("89, 144, 0 | ");
        long[] rtrndArr2 = productFib(5895);
        for(long ele : rtrndArr2) {
            System.out.print(ele + ", ");
        }
    }

    public static long[] productFib(long prod) {
        if (prod == 1) return new long[]{1,1,1};
        long x = 1;
        long y = 2;
        long temp;

        do {
            if (x * y == prod) {
                return new long[]{x,y,1};
            } else {
                temp = x + y;
                x = y;
                y = temp;
            }
        } while (x * y <= prod);

        return new long[]{x,y,0};
    }

    public static long multiply(long x, long y) {
        return x * y;
    }
}
