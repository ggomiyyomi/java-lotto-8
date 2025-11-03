package utils;

import java.text.DecimalFormat;

public class Formatter {
    private static final DecimalFormat percentFormat = new DecimalFormat("#,##0.0#");
    private static final DecimalFormat moneyFormat = new DecimalFormat("#,###");


    public static String formatProfit(double profitRate) {
        return percentFormat.format(profitRate) + "%";
    }

    public static String formatMoney(int amount) {
        return moneyFormat.format(amount) + "원";
    }
}
