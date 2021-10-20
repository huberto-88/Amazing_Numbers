package numbers;

import java.util.*;

public class Application {
    private final Scanner scanner = new Scanner(System.in);

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
                String firstCommand = null;
                String secondCommand = null;

                if (input.length > 3) {
                    secondCommand = input[3].toLowerCase();
                }
                if (input.length > 2) {
                    firstCommand = input[2].toLowerCase();
                }
                if (input.length > 1) {
                    consecutive = Integer.parseInt(input[1]);
                    for (int i = 0; i < consecutive; i++) {
                        listOfNumbers.add(number);
                        number++;
                    }
                }

                if (number < 0) {
                    throw new NotNaturalNumberException("The first parameter should be a natural number or zero.");
                } else if (consecutive < 0) {
                    throw new NotNaturalNumberException("The second parameter should be a natural number or zero.");
                }
                if (number == 0) {
                    System.out.println("Goodbye!");
                    break;
                }

                if (Objects.nonNull(firstCommand)) {
                    if ("buzz, duck, palindromic, gapful, spy, even, odd, sunny, square".contains(firstCommand)) {
                        displayInfoForNumbersAccordingToProperties(number, consecutive, firstCommand);
                    } else {
                        System.out.printf("The property [%s] is wrong.\n", firstCommand);
                        System.out.println("Available properties: " +
                                "[BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");
                    }
                }
                else if (input.length == 1) {
                    NumbersProperities.displayInfoAboutOneNumber(number);
                } else if (input.length == 2) {
                    NumbersProperities.displayInfoAboutListOfNumbers(listOfNumbers);
                }
            } catch (InputMismatchException | NotNaturalNumberException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

    private void displayInfoForNumbersAccordingToProperties(long number, int howMuch, String command) {
        switch (command) {
            case "even":
                NumbersProperities.findEvens(number, howMuch);
                break;
            case "odd":
                NumbersProperities.findOdds(number, howMuch);
                break;
            case "buzz":
                NumbersProperities.findBuzzes(number, howMuch);
                break;
            case "duck":
                NumbersProperities.findDucks(number, howMuch);
                break;
            case "palindromic":
                NumbersProperities.findPalindromics(number, howMuch);
                break;
            case "gapful":
                NumbersProperities.findGapfuls(number, howMuch);
                break;
            case "spy":
                NumbersProperities.findSpy(number, howMuch);
                break;
        }
    }

    public void runApplication() {
        System.out.println("Welcome to Amazing Numbers!");
        displayMenu();
    }

}