package domain.model;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> tickets;

    public LottoTicket(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    public int size() {
        return tickets.size();
    }
}
