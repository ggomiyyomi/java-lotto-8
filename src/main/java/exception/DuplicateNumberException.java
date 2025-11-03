package exception;

public class DuplicateNumberException extends IllegalArgumentException {
    public DuplicateNumberException(String message) {
        super("[ERROR] " + message);
    }
}
