package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class LottoControllerTest {

    @DisplayName("LottoController 객체 생성 시 예외가 발생하지 않는다")
    @Test
    void LottoController_생성_테스트() {
        assertThatCode(LottoController::new)
                .doesNotThrowAnyException();
    }
}
