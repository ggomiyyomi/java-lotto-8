package domain.service;

import java.util.Map;
import domain.value.Money;
import domain.value.Rank;

public class ProfitCalculator {
    public double calculateProfitRate(Map<Rank, Integer> results, int purchaseAmount) {
        
        //등수별 당첨 개수 * 상금
        double totalPrize = results.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        
        Money purchaseMoney = new Money(purchaseAmount);
        return purchaseMoney.calculateYield(totalPrize);
    }
}
