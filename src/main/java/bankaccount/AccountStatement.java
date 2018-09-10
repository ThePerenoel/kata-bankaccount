package bankaccount;

import java.time.LocalDate;
import java.util.Objects;

public class AccountStatement {
    private final LocalDate date;
    private final MoneyAmount amount;
    private final String type;

    public AccountStatement(LocalDate date, MoneyAmount amount) {
        this.date = date;
        this.amount = amount;
        this.type = "DEPOSIT";
    }

    public AccountStatement(String type, LocalDate date, MoneyAmount moneyAmount) {
        this.type = type;
        this.date = date;
        this.amount = moneyAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountStatement that = (AccountStatement) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, type);
    }

    @Override
    public String toString() {
        return "AccountStatement{" +
                "date=" + date +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
