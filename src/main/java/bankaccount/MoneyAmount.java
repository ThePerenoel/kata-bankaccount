package bankaccount;

import java.util.Objects;

public class MoneyAmount {
    private final int amount;

    public MoneyAmount(int amount) {

        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyAmount that = (MoneyAmount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "MoneyAmount{" +
                "amount=" + amount +
                '}';
    }

    public MoneyAmount getOpposite() {
        return new MoneyAmount(-this.amount);
    }
}
