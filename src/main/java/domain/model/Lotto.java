package domain.model;

import java.util.List;
import utils.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
