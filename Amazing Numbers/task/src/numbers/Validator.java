package numbers;

import java.util.ArrayList;
import java.util.List;
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

    public static void validateRequest(List<String> requests) throws WrongRequestException {
        List<String> wrongRequests = new ArrayList<>();

        for (String request : requests) {
            if (!"buzz, duck, palindromic, gapful, spy, even, odd, sunny, square, jumping, happy, sad".contains(request)) {
                wrongRequests.add(request);
            }
        }
        if (!wrongRequests.isEmpty()) {
            String errors = wrongRequests.size() > 1 ?
                    "ies " + wrongRequests + " are" : "y " + wrongRequests + " is";
            String message = String.format("The propert%s wrong.\n" +
                    "Available properties: " + "[BUZZ, DUCK, PALINDROMIC, GAPFUL, " +
                    "SPY, EVEN, ODD, SUNNY, SQUARE, JUMPING, HAPPY, SAD]", errors);
            throw new WrongRequestException(message);
        }
    }

    public static void validateMutuallyRequest(List<String> wanted, List<String> unwanted) throws WrongRequestException {
        String mutualPair = null;

        for (String request : wanted) {
            if (unwanted.contains(request)) {
                mutualPair = request + ", -" + request;
            }
        }

        if (wanted.contains("even") && wanted.contains("odd")) {
            mutualPair = "even, odd";
        }

        if (wanted.contains("duck") && wanted.contains("spy")) {
            mutualPair = "duck, spy";
        }
        if (wanted.contains("sunny") && wanted.contains("square")) {
            mutualPair = "sunny, square";
        }
        if (wanted.contains("happy") && wanted.contains("sad")) {
            mutualPair = "happy, sad";
        }

        if (unwanted.contains("even") && unwanted.contains("odd")) {
            mutualPair = "-even, -odd";
        }

        if (unwanted.contains("duck") && unwanted.contains("spy")) {
            mutualPair = "-duck, -spy";
        }
        if (unwanted.contains("sunny") && unwanted.contains("square")) {
            mutualPair = "-sunny, -square";
        }
        if (unwanted.contains("happy") && unwanted.contains("sad")) {
            mutualPair = "-happy, -sad";
        }

        if (Objects.nonNull(mutualPair)) {
            String message = String.format("The request contains mutually exclusive properties: [%s]\n" +
                    "There are no numbers with these properties.", mutualPair);
            throw new WrongRequestException(message);
        }
    }
}
