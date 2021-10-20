package numbers;

import java.util.Objects;

public class Validator {

    public static void isNumberCorrect(long first, long second) throws WrongRequestException {
        if (first < 0) {
            throw new WrongRequestException("The first parameter should be a natural number or zero.");
        }
        if (second < 0) {
            throw new WrongRequestException("The second parameter should be a natural number or zero.");
        }
    }

    public static void validateRequest(String request) throws WrongRequestException {
        if (!validate(request)) {
            String message = String.format("The property [%s] is wrong.\n" +
                    "Available properties: " + "[BUZZ, DUCK, PALINDROMIC, GAPFUL, " +
                    "SPY, EVEN, ODD, SUNNY, SQUARE]", request);
            throw new WrongRequestException(message);
        }
    }

    public static void validateTwoRequests(String firstRequest, String secondRequest) throws WrongRequestException {
        if (!validate(firstRequest) && !validate(secondRequest)) {
            String message = String.format("The properties [%s, %s] are wrong.\n" +
                    "Available properties: " + "[BUZZ, DUCK, PALINDROMIC, GAPFUL, " +
                    "SPY, EVEN, ODD, SUNNY, SQUARE]", firstRequest, secondRequest);
            throw new WrongRequestException(message);
        }
    }

    public static void validateMutuallyRequests(String firstRequest, String secondRequest) throws WrongRequestException {
        if (("even odd".contains(firstRequest) && "even odd".contains(secondRequest))
                || ("duck spy".contains(firstRequest) && "duck spy".contains(secondRequest))
                || ("sunny square".contains(firstRequest) && "sunny square".contains(secondRequest))
        ) {
            String message = String.format("The request contains mutually exclusive properties: [%s, %s]\n" +
                    "There are no numbers with these properties.", firstRequest, secondRequest);
            throw new WrongRequestException(message);
        }
    }

    private static boolean validate(String request) {
        return "buzz, duck, palindromic, gapful, spy, even, odd, sunny, square".contains(request);
    }
}
