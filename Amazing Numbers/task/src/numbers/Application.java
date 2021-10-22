package numbers;

import java.util.*;
import java.util.function.LongPredicate;

public class Application {
    private final Scanner scanner = new Scanner(System.in);

    public void runApplication() {
        displayInfo();

        while (true) {
            System.out.println("Enter a request:");
            try {
                String[] input = scanner.nextLine().split("\\s+");
                int howMany = 0;
                long number = Long.parseLong(input[0]);
                List<String> requests = new ArrayList<>();

                if (input.length > 1) {
                    howMany = Integer.parseInt(input[1]);
                }

                Validator.isNumberCorrect(number, howMany);

                if (number == 0) {
                    System.out.println("Goodbye!");
                    break;
                }

                if (input.length > 2) {
                    for (int i = 2; i < input.length; i++) {
                        requests.add(input[i].toLowerCase());
                    }

                    Validator.validateRequest(requests);
                    Validator.validateMutuallyRequest(requests);
                }

                displayInfoNumbers(number, howMany, requests);

            } catch (InputMismatchException | WrongRequestException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

    private void displayInfoNumbers(long number, int howMany, List<String> requests) {
        if (!requests.isEmpty()) {
            List<LongPredicate> predicates = new ArrayList<>();
            requests.forEach(request -> predicates.add(getPredicate(request)));
            NumbersProperities.displayByRequest(predicates, number, howMany);
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

    public void displayInfo() {
        System.out.println("Welcome to Amazing Numbers!");

        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }

}