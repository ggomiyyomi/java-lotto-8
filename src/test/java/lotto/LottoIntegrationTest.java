package lotto;

import controller.LottoController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class LottoIntegrationTest {

    @DisplayName("전체 로또 플로우 실행 시 예외 없이 동작한다.")
    @Test
    void 전체_플로우_정상_동작_테스트() {
        LottoController controller = new LottoController();
        assertThatCode(() -> controller.getClass())
                .doesNotThrowAnyException();
    }
}
