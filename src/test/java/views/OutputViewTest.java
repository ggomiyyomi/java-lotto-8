package views;

import static org.assertj.core.api.Assertions.assertThatCode;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import domain.model.Lotto;
import domain.model.LottoTicket;
import domain.value.Rank;

class OutputViewTest {

    @Test
    void 출력_메서드_정상_동작() {
        OutputView view = new OutputView();
        LottoTicket ticket = new LottoTicket(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        Map<Rank, Integer> result = Map.of(Rank.FIFTH, 1);
        assertThatCode(() -> view.printStatistics(result, 62.5))
                .doesNotThrowAnyException();
    }
}
