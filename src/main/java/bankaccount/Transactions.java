package bankaccount;

public interface Transactions {
    void add(Integer amount);

    void add(BankOperation operation);

    int sumAll();
}
