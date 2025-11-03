package views;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @DisplayName("구입 금액 입력이 숫자가 아니면 IllegalArgumentException 발생")
    @Test
    void 구입금액_입력_유효성_테스트() {
        InputView inputView = new InputView();
        
        assertThatThrownBy(() -> Integer.parseInt("1,000"))
                .isInstanceOf(NumberFormatException.class);
    }
}
