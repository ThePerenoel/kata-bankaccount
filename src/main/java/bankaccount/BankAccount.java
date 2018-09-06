package bankaccount;

public class BankAccount {
    private final Transactions transactions;

    public BankAccount(Transactions transactions) {
        this.transactions = transactions;
    }

    public void deposit(Integer amount) {
        this.transactions.add(amount);
    }
}
