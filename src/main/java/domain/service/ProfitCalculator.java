package domain.service;

import domain.value.Rank;
import java.util.Map;

public class ProfitCalculator {
    public double calculateProfitRate(Map<Rank, Integer> results, int purchaseAmount) {
        
        //등수별 당첨 개수 * 상금
        double totalPrize = results.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        
        return (totalPrize / purchaseAmount) * 100;
    }
}
