package utils;

import exception.DuplicateNumberException;
import exception.InvalidInputException;
import exception.LottoNumberOutOfRangeException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int LOTTO_PRICE = 1000;

    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new InvalidInputException("구입 금액은 1,000원 단위의 양수여야 합니다.");
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidInputException("로또 번호는 6개여야 합니다.");
        }

        Set<Integer> unique = new HashSet<>(numbers);
        if (unique.size() != 6) {
            throw new DuplicateNumberException("중복된 로또 번호가 존재합니다.");
        }

        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new LottoNumberOutOfRangeException("로또 번호는 1부터 45 사이여야 합니다.");
            }
        }
    }

    public static void validateBonusNumber(int bonus, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonus)) {
            throw new DuplicateNumberException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
