package domain.service;

import domain.model.Lotto;
import domain.model.LottoTicket;
import utils.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public LottoTicket purchase(int amount) {
        int count = amount / LOTTO_PRICE;
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            tickets.add(new Lotto(LottoNumberGenerator.generateNumbers()));
        }

        return new LottoTicket(tickets);
    }
}
