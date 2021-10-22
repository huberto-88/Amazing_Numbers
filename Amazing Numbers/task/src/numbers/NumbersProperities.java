package numbers;

import java.util.List;
import java.util.function.LongPredicate;

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
        System.out.println("     jumping: " + checkIsJumping.test(number));
    }

    public static void displayInfoAboutListOfNumbers(long number, int howMany) {
        for (int i = 0; i < howMany; i++) {
            System.out.printf("%d is %s%s%s%s%s%s%s%s%s\n", number,
                    checkIsEven.test(number) ? "even, " : "odd, ",
                    checkIsBuzz.test(number) ? "buzz, " : "",
                    checkIsDuck.test(number) ? "duck, " : "",
                    checkIsPalindromic.test(number) ? "palindromic, " : "",
                    checkIsGapful.test(number) ? "gapful " : "",
                    checkIsSpy.test(number) ? "spy, " : "",
                    checkIsSunny.test(number) ? "sunny, " : "",
                    checkIsSquare.test(number) ? "square, " : "",
                    checkIsJumping.test(number) ? "jumping, " : ""
            );
            number++;
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

    // jumping
    public static LongPredicate checkIsJumping = number -> {
        if (number < 10) {
            return true;
        }

        String[] nString = String.valueOf(number).split("");
        for (int i = 1; i < nString.length; i++) {
            if (Math.abs((Integer.parseInt(nString[i - 1]) - (Integer.parseInt(nString[i])))) != 1) {
                return false;
            }
        }
        return true;
    };

//    ------------------------------------------------------------------------------------------------------------

    public static void displayByRequest(List<LongPredicate> check, long number, int howMany) {
        while (howMany > 0) {
            boolean numberIsOk = true;
            for (int i = 0; i < check.size(); i++) {
                if (!check.get(i).test(number)) {
                    numberIsOk = false;
                    break;
                }
            }
            if (numberIsOk) {
                displayInfoAboutListOfNumbers(number, 1);
                howMany--;
            }
            number++;
        }
    }
}
