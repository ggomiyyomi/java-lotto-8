package domain.service;

import domain.model.Lotto;
import domain.model.LottoTicket;
import domain.model.WinningLotto;
import domain.value.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCalculatorTest {

    @Test
    void 당첨_결과_정확히_계산된다() {
        LottoTicket ticket = new LottoTicket(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        ));
        WinningLotto winning = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoResultCalculator calc = new LottoResultCalculator();

        Map<Rank, Integer> result = calc.calculate(ticket, winning);

        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
    }
}
