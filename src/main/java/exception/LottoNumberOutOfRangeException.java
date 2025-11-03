package exception;

public class LottoNumberOutOfRangeException extends IllegalArgumentException {
    public LottoNumberOutOfRangeException(String message) {
        super("[ERROR] " + message);
    }
}
