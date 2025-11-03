package utils;

import exception.DuplicateNumberException;
import exception.InvalidInputException;
import exception.LottoNumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("구입 금액이 0 이하이거나 1000단위가 아니면 InvalidInputException 발생")
    @Test
    void 구입금액_검증_테스트() {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(-1000))
                .isInstanceOf(InvalidInputException.class);
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(1234))
                .isInstanceOf(InvalidInputException.class);
    }

    @DisplayName("로또 번호가 6개가 아니면 InvalidInputException 발생")
    @Test
    void 로또번호_개수_검증() {
        assertThatThrownBy(() -> Validator.validateLottoNumbers(List.of(1, 2, 3)))
                .isInstanceOf(InvalidInputException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 DuplicateNumberException 발생")
    @Test
    void 중복된_번호_검증() {
        assertThatThrownBy(() -> Validator.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(DuplicateNumberException.class);
    }

    @DisplayName("로또 번호가 1~45 범위를 벗어나면 LottoNumberOutOfRangeException 발생")
    @Test
    void 번호범위_검증() {
        assertThatThrownBy(() -> Validator.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 100)))
                .isInstanceOf(LottoNumberOutOfRangeException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되면 DuplicateNumberException 발생")
    @Test
    void 보너스번호_중복_검증() {
        assertThatThrownBy(() -> Validator.validateBonusNumber(3, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(DuplicateNumberException.class);
    }
}
