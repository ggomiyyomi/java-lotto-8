package domain.value;

public class Money {
    private final int amount;

    public Money(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야 합니다.");
        }
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isDivisibleBy(int unit) {
        return amount % unit == 0;
    }

    public int divideBy(int divisor) {
        return amount / divisor;
    }

    public double calculateYield(double totalPrize) {
        return (totalPrize / amount) * 100;
    }
}
