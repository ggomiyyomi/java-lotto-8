package domain.service;

import domain.model.Lotto;
import domain.model.LottoTicket;
import domain.model.WinningLotto;
import domain.value.Rank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {
    //로또 여러장 
    public Map<Rank, Integer> calculate(LottoTicket ticket, WinningLotto winningLotto) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        for (Lotto lotto : ticket.getTickets()) {
            Rank rank = findRank(lotto, winningLotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }

    //단일 
    private Rank findRank(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> userNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getWinningNumbers();

        long count = userNumbers.stream().filter(winningNumbers::contains).count();
       
        boolean bonusMatch = userNumbers.contains(winningLotto.getBonusNumber());

        return Rank.valueOf((int) count, bonusMatch);
    }
}
