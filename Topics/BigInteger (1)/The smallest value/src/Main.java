import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger m = scanner.nextBigInteger();
        System.out.println(smallestN(m));
    }

    public static long smallestN(BigInteger m) {
        long n = 0;
        BigInteger calc = BigInteger.ONE;

        while (calc.compareTo(m) == -1) {
            n++;
            calc = calc.multiply(BigInteger.valueOf(n));
        }
        return n;
    }
}