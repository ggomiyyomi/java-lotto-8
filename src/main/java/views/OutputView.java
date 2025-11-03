package views;

import domain.model.LottoTicket;
import domain.value.Rank;
import utils.Formatter;

import java.util.Map;

public class OutputView {

    public void printPurchasedLottos(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.size() + "개를 구매했습니다.");
        lottoTicket.getTickets().forEach(lotto ->
                System.out.println(lotto.getNumbers()));
        System.out.println();
    }

    public void printStatistics(Map<Rank, Integer> results, String formattedProfit) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue;
            int count = results.getOrDefault(rank, 0);
            System.out.printf("%s - %d개%n", rank.getDescription(), count);
        }
        System.out.printf("총 수익률은 %s입니다.%n", formattedProfit);
    }
}
