package domain.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    void 구매한_로또_개수_정확히_반환() {
        LottoTicket ticket = new LottoTicket(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));
        assertThat(ticket.size()).isEqualTo(2);
    }
}
