package utils;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class FormatterTest {

    @Test
    void 수익률_형식_출력_검증() {
        assertThat(Formatter.formatProfit(62.5)).isEqualTo("62.5%");
    }

    @Test
    void 금액_형식_출력_검증() {
        assertThat(Formatter.formatMoney(1234567)).isEqualTo("1,234,567원");
    }
}
