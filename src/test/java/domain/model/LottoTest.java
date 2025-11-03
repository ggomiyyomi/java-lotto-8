package domain.model;

import exception.DuplicateNumberException;
import exception.InvalidInputException;
import exception.LottoNumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호가 6개보다 많으면 InvalidInputException 발생")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다");
    }

    @DisplayName("로또 번호가 6개보다 적으면 InvalidInputException 발생")
    @Test
    void 로또_번호가_6개보다_적으면_예외발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3)))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다");
    }

    @DisplayName("중복된 숫자가 있으면 DuplicateNumberException 발생")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(DuplicateNumberException.class)
                .hasMessageContaining("중복된 로또 번호가 존재합니다");
    }

    @DisplayName("범위를 벗어난 숫자가 있으면 LottoNumberOutOfRangeException 발생")
    @Test
    void 로또_번호가_1에서_45_사이가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(LottoNumberOutOfRangeException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이여야 합니다");
    }

    @DisplayName("정상적인 로또 번호 생성 시 그대로 저장된다")
    @Test
    void 정상_로또_생성() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
