package bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestTransactions implements Transactions {

    private List<BankOperation> operations;

    public TestTransactions() {
        operations = new ArrayList<>();
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
        return Objects.equals(operations, that.operations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operations);
    }

    @Override
    public String toString() {
        return "TestTransactions{" +
                "operations=" + operations +
                '}';
    }
}
