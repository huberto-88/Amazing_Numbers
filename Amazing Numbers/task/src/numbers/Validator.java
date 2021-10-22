package numbers;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static void isNumberCorrect(long first, long second) throws NotNaturalNumberException {
        if (first < 0) {
            throw new NotNaturalNumberException("The first parameter should be a natural number or zero.");
        }
        if (second < 0) {
            throw new NotNaturalNumberException("The second parameter should be a natural number or zero.");
        }
    }

    public static void validateRequests(List<String> wanted, List<String> unwanted) throws WrongRequestException, MutualRequestException {
        validate(wanted);
        validate(unwanted);
        validateMutuallyRequest(wanted, unwanted);
    }

    public static void validate(List<String> requests) throws WrongRequestException {
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

    public static void validateMutuallyRequest(List<String> wanted, List<String> unwanted) throws MutualRequestException {
        for (String request : wanted) {
            if (unwanted.contains(request)) {
                throw new MutualRequestException(request + ", " + request);
            }
        }

        if (wanted.contains("even") && wanted.contains("odd")) {
            throw new MutualRequestException("even, odd");
        }
        if (wanted.contains("duck") && wanted.contains("spy")) {
            throw new MutualRequestException("duck, spy");
        }
        if (wanted.contains("sunny") && wanted.contains("square")) {
            throw new MutualRequestException("sunny, square");
        }
        if (wanted.contains("happy") && wanted.contains("sad")) {
            throw new MutualRequestException("happy, sad");
        }
        if (unwanted.contains("even") && unwanted.contains("odd")) {
            throw new MutualRequestException("-even, -odd");
        }
        if (unwanted.contains("duck") && unwanted.contains("spy")) {
            throw new MutualRequestException("-duck, -spy");
        }
        if (unwanted.contains("sunny") && unwanted.contains("square")) {
            throw new MutualRequestException("-sunny, -square");
        }
        if (unwanted.contains("happy") && unwanted.contains("sad")) {
            throw new MutualRequestException("-happy, -sad");
        }
    }
}
