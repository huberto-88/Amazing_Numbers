import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(smallestIntNumber(scanner.nextLong()));
        scanner.close();
    }

    private static int smallestIntNumber(long m) {
        int n = 1;
        long result = 1;

        while (result <= m) {
            n++;
            result *= n;
        }
        return n;
    }
}