package domain.service;

import domain.model.Lotto;
import domain.model.LottoTicket;
import domain.repository.LottoRepository;
import domain.value.Money;
import utils.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public LottoTicket purchase(int amount) {
        Money money = new Money(amount);
        int count = money.divideBy(LOTTO_PRICE);
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateNumbers());
            tickets.add(lotto);
            LottoRepository.save(lotto);
        }

        return new LottoTicket(tickets);
    }
}
