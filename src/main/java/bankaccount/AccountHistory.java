package bankaccount;

import java.util.Objects;

public class AccountHistory {
    private final Transactions transactions;
    private final int balance;

    public AccountHistory(Transactions transactions, int balance) {

        this.transactions = transactions;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountHistory that = (AccountHistory) o;
        return balance == that.balance &&
                Objects.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions, balance);
    }

    @Override
    public String toString() {
        return "AccountHistory{" +
                "transactions=" + transactions +
                ", balance=" + balance +
                '}';
    }
}
