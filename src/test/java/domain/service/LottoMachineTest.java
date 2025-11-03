package domain.service;

import domain.model.LottoTicket;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void 구입금액에_맞는_로또개수가_생성된다() {
        LottoMachine machine = new LottoMachine();
        LottoTicket ticket = machine.purchase(5000);
        assertThat(ticket.size()).isEqualTo(5);
    }
}
