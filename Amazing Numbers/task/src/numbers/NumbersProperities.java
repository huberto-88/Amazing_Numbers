package numbers;

import java.util.List;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class NumbersProperities {

    /**
     * Check if number is odd, ever or Buzz Number
     * If number ends with 7 or is divisible by 7 it is Buzz Number
     */
    public static void displayInfoAboutOneNumber(long number) {
        String nString = String.valueOf(number);

        System.out.println("Properties of " + nString);
        System.out.println("        even: " + checkIsEven.test(number));
        System.out.println("         odd: " + checkIsOdd.test(number));
        System.out.println("        buzz: " + checkIsBuzz.test(number));
        System.out.println("        duck: " + checkIsDuck.test(number));
        System.out.println(" palindromic: " + checkIsPalindromic.test(number));
        System.out.println("      gapful: " + checkIsGapful.test(number));
        System.out.println("         spy: " + checkIsSpy.test(number));
        System.out.println("       sunny: " + checkIsSunny.test(number));
        System.out.println("      square: " + checkIsSquare.test(number));
    }

    public static void displayInfoAboutListOfNumbers(List<Long> listOfNumbers) {
        for (long number : listOfNumbers) {
            System.out.printf("%d is %s%s%s%s%s%s%s%s\n", number,
                    checkIsEven.test(number) ? "even, " : "odd, ",
                    checkIsBuzz.test(number) ? "buzz, " : "",
                    checkIsDuck.test(number) ? "duck, " : "",
                    checkIsPalindromic.test(number) ? "palindromic, " : "",
                    checkIsGapful.test(number) ? "gapful " : "",
                    checkIsSpy.test(number) ? "spy, " : "",
                    checkIsSunny.test(number) ? "sunny, " : "",
                    checkIsSquare.test(number) ? "square, " : ""
            );
        }
    }

//    ----------------------------------------------------------------------------------------

    // even
    public static LongPredicate checkIsEven = number -> number % 2 == 0;

    // odd
    public static LongPredicate checkIsOdd = number -> !(number % 2 == 0);

    // palindromic
    public static LongPredicate checkIsPalindromic = number -> {
        String nString = String.valueOf(number);
        return nString.equals(new StringBuilder(nString).reverse().toString());
    };

    // duck
    public static LongPredicate checkIsDuck = number -> {
        String nString = String.valueOf(number);
        return nString.contains("0");

    };

    // buzz
    public static LongPredicate checkIsBuzz = number -> {
        String nString = String.valueOf(number);
        return number % 7 == 0 || nString.charAt(nString.length() - 1) == '7';
    };

    // gapful
    public static LongPredicate checkIsGapful = number -> {
        String nString = String.valueOf(number);
        if (nString.length() < 3) {
            return false;
        } else {
            int firstLast = Integer.parseInt(nString.charAt(0)
                    + String.valueOf(nString.charAt(nString.length() - 1))
            );
            return number % firstLast == 0;
        }
    };

    // spy
    public static LongPredicate checkIsSpy = number -> {
        String nString = String.valueOf(number);
        int sum = 0;
        int product = 1;
        for (int i = 0; i < nString.length(); i++) {
            int temp = Integer.parseInt(String.valueOf(nString.charAt(i)));
            sum += temp;
            product *= temp;
        }
        return sum == product;
    };

    // square
    public static LongPredicate checkIsSquare = number -> {
        long temp = (long) Math.sqrt(number);
        return number == temp * temp;
    };

    // sunny
    public static LongPredicate checkIsSunny = number -> {
        return checkIsSquare.test(number + 1);
    };

//    ------------------------------------------------------------------------------------------------------------

    public static void displayByRequest(LongPredicate check, long number, int howMuch) {
        while (howMuch > 0) {
            if (check.test(number)) {
                displayInfoAboutListOfNumbers(List.of(number));
                howMuch--;
            }
            number++;
        }
    }

    public static void displayByRequest(LongPredicate check1, LongPredicate check2, long number, int howMuch) {
        while (howMuch > 0) {
            if (check1.test(number) && check2.test(number)) {
                displayInfoAboutListOfNumbers(List.of(number));
                howMuch--;
            }
            number++;
        }
    }
}
