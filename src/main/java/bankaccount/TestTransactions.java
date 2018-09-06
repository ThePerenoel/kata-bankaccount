package bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestTransactions implements Transactions {

    private List<Integer> transactions;
    private List<BankOperation> operations;

    public TestTransactions() {
        transactions = new ArrayList<>();
        operations = new ArrayList<>();
    }

    public void add(Integer amount) {
        this.transactions.add(amount);
    }

    @Override
    public void add(BankOperation operation) {
        this.operations.add(operation);
    }

    @Override
    public int sumAll() {
        return this.operations.stream().mapToInt(BankOperation::getAmount).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestTransactions that = (TestTransactions) o;
        return Objects.equals(transactions, that.transactions) &&
                Objects.equals(operations, that.operations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions, operations);
    }

    @Override
    public String toString() {
        return "TestTransactions{" +
                "transactions=" + transactions +
                ", operations=" + operations +
                '}';
    }
}
