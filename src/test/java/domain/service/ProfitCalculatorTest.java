package domain.service;

import domain.value.Rank;
import org.junit.jupiter.api.Test;
import java.util.EnumMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {

    @Test
    void 수익률_정상_계산() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        result.put(Rank.FIFTH, 2);
        ProfitCalculator calc = new ProfitCalculator();

        double profitRate = calc.calculateProfitRate(result, 8000);
        assertThat(profitRate).isEqualTo(125.0);
    }
}
