package bankaccount;

public interface Transactions {

    void add(BankOperation operation);

    int sumAll();
}
