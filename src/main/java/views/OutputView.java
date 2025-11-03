package views;

import domain.model.LottoTicket;
import domain.value.Rank;

import java.util.Map;

public class OutputView {
    
    public void printPurchasedLottos(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.size() + "개를 구매했습니다.");
        lottoTicket.getTickets().forEach(lotto ->
                System.out.println(lotto.getNumbers()));
    }

    public void printStatistics(Map<Rank, Integer> results, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            //꽝제외 
            if (rank == Rank.NONE) continue;
            System.out.printf("%s - %d개%n", rank.getDescription(), results.getOrDefault(rank, 0));
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
