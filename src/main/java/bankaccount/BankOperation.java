package bankaccount;

import java.time.LocalTime;
import java.util.Objects;

public class BankOperation {
    private final String type;
    private final int amount;
    private final LocalTime time;

    public BankOperation(String type, int amount, LocalTime time) {
        this.type = type;
        this.amount = amount;
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankOperation that = (BankOperation) o;
        return amount == that.amount &&
                Objects.equals(type, that.type) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, amount, time);
    }

    @Override
    public String toString() {
        return "BankOperation{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", time=" + time +
                '}';
    }
}
