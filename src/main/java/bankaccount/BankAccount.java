package bankaccount;

public class BankAccount {
    private final Transactions transactions;

    public BankAccount(Transactions transactions) {
        this.transactions = transactions;
    }

    public void deposit(Integer amount) {
        this.transactions.add(amount);
    }

    public void withdraw(Integer amount) {
        this.transactions.add(-amount);
    }

    public void depositWithDate(BankOperation operation) {
        this.transactions.add(operation);
    }

    public void withdrawWithDate(BankOperation bankOperation) {
        this.transactions.add(bankOperation);
    }
}
