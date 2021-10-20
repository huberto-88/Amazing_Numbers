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
                "- enter a natural number to know its properties; \n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and a property to search for;\n" +
                "- two natural numbers and two properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");


        while (true) {
            System.out.println("Enter a request:");
            try {
                String[] input = scanner.nextLine().split("\\s+");
                long number = Long.parseLong(input[0]);
                int consecutive = 1;
                List<Long> listOfNumbers = new ArrayList<>();
                String firstRequest = null;
                String secondRequest = null;

                if (input.length > 1) {
                    consecutive = Integer.parseInt(input[1]);
                }

                Validator.isNumberCorrect(number, consecutive);

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



                for (int i = 0; i < consecutive; i++) {
                    listOfNumbers.add(number);
                    number++;
                }
                displayInfoNumbers(listOfNumbers, consecutive, firstRequest, secondRequest);


            } catch (InputMismatchException | WrongRequestException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

    private void displayInfoNumbers(List<Long> listOfNumbers, int howMuch, String firstRequest, String secondRequest) {
        long number = listOfNumbers.get(0);

        if (Objects.nonNull(secondRequest)) {
            NumbersProperities.displayByRequest(getPredicate(firstRequest), getPredicate(secondRequest), number, howMuch);
        } else if (Objects.nonNull(firstRequest)) {
            NumbersProperities.displayByRequest(getPredicate(firstRequest), number, howMuch);
        } else if (howMuch > 1){
            NumbersProperities.displayInfoAboutListOfNumbers(listOfNumbers);
        } else if (howMuch == 1) {
            NumbersProperities.displayInfoAboutOneNumber(listOfNumbers.get(0));
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
        }
        return null;
    }

}