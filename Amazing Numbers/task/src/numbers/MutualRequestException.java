package numbers;

public class MutualRequestException extends Exception {
    public MutualRequestException(String details) {
        super(String.format("The request contains mutually exclusive properties: [%s]\n" +
                "There are no numbers with these properties.", details));
    }
}