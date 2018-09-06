package bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestTransactions implements Transactions {

    private List<Integer> transactions = new ArrayList<>();

    public void add(Integer amount) {
        this.transactions.add(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestTransactions that = (TestTransactions) o;
        return Objects.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions);
    }

    @Override
    public String toString() {
        return "TestTransactions{" +
                "transactions=" + transactions +
                '}';
    }
}
