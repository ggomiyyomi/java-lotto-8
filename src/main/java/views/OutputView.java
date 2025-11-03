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

    public void printStatistics(Map<Rank, Integer> results, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Rank[] printOrder = {
                Rank.FIFTH,    
                Rank.FOURTH,  
                Rank.THIRD,    
                Rank.SECOND,  
                Rank.FIRST    
        };
        for (Rank rank : printOrder) {
            int count = results.getOrDefault(rank, 0);
            System.out.printf("%s - %d개%n", rank.getDescription(), count);
        }
 
        System.out.println("총 수익률은 " + Formatter.formatProfit(profitRate) + "입니다.");
    }

}
