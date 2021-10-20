package numbers;

import java.util.*;
import java.util.function.LongPredicate;

public class Application {
    private final Scanner scanner = new Scanner(System.in);

    public void runApplication() {
        System.out.println("Welcome to Amazing Numbers!");
        displayMenu();
    }

    /**
     * Ask user for number to check
     * If user's input isn't natural number than return false
     * If user put natural number, return true
     */
    private void displayMenu() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");

        while (true) {
            System.out.println("Enter a request:");
            try {
                String[] input = scanner.nextLine().split("\\s+");
                int howMany = 0;
                long number = Long.parseLong(input[0]);
                String firstRequest = null;
                String secondRequest = null;

                if (input.length > 1) {
                    howMany = Integer.parseInt(input[1]);
                }

                Validator.isNumberCorrect(number, howMany);

                if (number == 0) {
                    System.out.println("Goodbye!");
                    break;
                }

                if (input.length == 3) {
                    firstRequest = input[2].toLowerCase();
                    Validator.validateRequest(firstRequest);
                }
                if (input.length == 4) {
                    firstRequest = input[2].toLowerCase();
                    secondRequest = input[3].toLowerCase();
                    Validator.validateTwoRequests(firstRequest, secondRequest);
                    Validator.validateRequest(firstRequest);
                    Validator.validateRequest(secondRequest);
                    Validator.validateMutuallyRequests(firstRequest, secondRequest);
                }

                displayInfoNumbers(number, howMany, firstRequest, secondRequest);

            } catch (InputMismatchException | WrongRequestException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

    private void displayInfoNumbers(long number, int howMany, String firstRequest, String secondRequest) {
        if (Objects.nonNull(secondRequest)) {
            NumbersProperities.displayByRequest(getPredicate(firstRequest), getPredicate(secondRequest), number, howMany);
        } else if (Objects.nonNull(firstRequest)) {
            NumbersProperities.displayByRequest(getPredicate(firstRequest), number, howMany);
        } else if (howMany > 0){
            NumbersProperities.displayInfoAboutListOfNumbers(number, howMany);
        } else if (howMany == 0) {
            NumbersProperities.displayInfoAboutOneNumber(number);
        }
    }

    private LongPredicate getPredicate(String request) {
        switch (request) {
            case "even":
                return NumbersProperities.checkIsEven;
            case "odd":
                return NumbersProperities.checkIsOdd;
            case "buzz":
                return NumbersProperities.checkIsBuzz;
            case "duck":
                return NumbersProperities.checkIsDuck;
            case "palindromic":
                return NumbersProperities.checkIsPalindromic;
            case "gapful":
                return NumbersProperities.checkIsGapful;
            case "spy":
                return NumbersProperities.checkIsSpy;
            case "square":
                return NumbersProperities.checkIsSquare;
            case "sunny":
                return NumbersProperities.checkIsSunny;
            case "jumping":
                return NumbersProperities.checkIsJumping;
        }
        return null;
    }

}