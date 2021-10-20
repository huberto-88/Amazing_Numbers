package numbers;

import java.util.List;
import java.util.function.Predicate;

public class NumbersProperities {

    /**
     * Check if number is odd, ever or Buzz Number
     * If number ends with 7 or is divisible by 7 it is Buzz Number
     */
    public static void displayInfoAboutOneNumber(long number) {
        String nString = String.valueOf(number);

        System.out.println("Properties of " + nString);
        System.out.println("        even: " + checkIsEven(number));
        System.out.println("         odd: " + !checkIsEven(number));
        System.out.println("        buzz: " + checkIsBuzz(number, nString));
        System.out.println("        duck: " + checkIsDuck(nString));
        System.out.println(" palindromic: " + checkIsPalindromic(nString));
        System.out.println("      gapful: " + checkIsGapful(number, nString));
        System.out.println("         spy: " + checkIsSpy(nString));
        System.out.println("       sunny: " + checkIsSunny(number));
        System.out.println("      square: " + checkIsSquare(number));
    }

    public static void displayInfoAboutListOfNumbers(List<Long> listOfNumbers) {
        for (long number : listOfNumbers) {
            String nString = String.valueOf(number);

            System.out.printf("%d is %s%s%s%s%s%s%s%s\n", number,
                    checkIsEven(number) ? "even, " : "odd, ",
                    checkIsBuzz(number, nString) ? "buzz, " : "",
                    checkIsDuck(nString) ? "duck, " : "",
                    checkIsPalindromic(nString) ? "palindromic, " : "",
                    checkIsGapful(number, nString) ? "gapful " : "",
                    checkIsSpy(nString) ? "spy, " : "",
                    checkIsSunny(number) ? "sunny, " : "",
                    checkIsSquare(number) ? "square, " : ""
            );
        }
    }

//    ------------------------------------------------------------------------------------------------------------

    // spy
    private static boolean checkIsSpy(String nString) {
        int sum = 0;
        int product = 1;
        for (int i = 0; i < nString.length(); i++) {
            int temp = Integer.parseInt(String.valueOf(nString.charAt(i)));
            sum += temp;
            product *= temp;
        }
        return sum == product;
    }

    // gapful
    private static boolean checkIsGapful(long number, String nString) {
        if (nString.length() < 3) {
            return false;
        } else {
            int firstLast = Integer.parseInt(nString.charAt(0)
                    + String.valueOf(nString.charAt(nString.length() - 1))
            );
            return number % firstLast == 0;
        }
    }

    // palindromic
    private static boolean checkIsPalindromic(String nString) {
        return nString.equals(new StringBuilder(nString).reverse().toString());
    }

    // duck
    private static boolean checkIsDuck(String nString) {
        return nString.contains("0");
    }

    // buzz
    private static boolean checkIsBuzz(long number, String nString) {
        return number % 7 == 0 || nString.charAt(nString.length() - 1) == '7';
    }

    // even !even
    private static boolean checkIsEven(long number) {
        return number % 2 == 0;
    }

    // square
    private static boolean checkIsSquare(long number) {
        long temp = (long) Math.sqrt(number);
        return number == temp * temp;
    }

    // sunny
    private static boolean checkIsSunny(long number) {
        return checkIsSquare(number + 1);
    }

//    ------------------------------------------------------------------------------------------------------------

    public static void findEvens(long number, int howMuch) {
        while (howMuch > 0) {
            if (checkIsEven(number)) {
                displayInfoAboutListOfNumbers(List.of(number));
                howMuch--;
            }
            number++;
        }
    }

    public static void findOdds(long number, int howMuch) {
        while (howMuch > 0) {
            if (!checkIsEven(number)) {
                displayInfoAboutListOfNumbers(List.of(number));
                howMuch--;
            }
            number++;
        }
    }

    public static void findBuzzes(long number, int howMuch) {
        while (howMuch > 0) {
            if (checkIsBuzz(number, String.valueOf(number))) {
                displayInfoAboutListOfNumbers(List.of(number));
                howMuch--;
            }
            number++;
        }
    }

    public static void findDucks(long number, int howMuch) {
        while (howMuch > 0) {
            if (checkIsDuck(String.valueOf(number))) {
                displayInfoAboutListOfNumbers(List.of(number));
                howMuch--;
            }
            number++;
        }
    }

    public static void findPalindromics(long number, int howMuch) {
        while (howMuch > 0) {
            if (checkIsPalindromic(String.valueOf(number))) {
                displayInfoAboutListOfNumbers(List.of(number));
                howMuch--;
            }
            number++;
        }
    }

    public static void findGapfuls(long number, int howMuch) {
        while (howMuch > 0) {
            if (checkIsGapful(number, String.valueOf(number))) {
                displayInfoAboutListOfNumbers(List.of(number));
                howMuch--;
            }
            number++;
        }
    }

    public static void findSpy(long number, int howMuch) {
        while (howMuch > 0) {
            if (checkIsSpy(String.valueOf(number))) {
                displayInfoAboutListOfNumbers(List.of(number));
                howMuch--;
            }
            number++;
        }
    }
}
