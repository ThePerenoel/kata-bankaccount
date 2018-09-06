package bankaccount;

import java.time.LocalTime;

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

    public void withdrawWithDate(int amount, LocalTime time) {
        BankOperation bankOperation = new BankOperation("WITHDRAWAL", amount, time);
        this.transactions.add(bankOperation);
    }

    public void depositWithDate(int amount, LocalTime time) {
        BankOperation bankOperation = new BankOperation("DEPOSIT", amount, time);
        this.transactions.add(bankOperation);
    }

    public AccountHistory getAccountHistory() {
        int balance = this.transactions.sumAll();
        return new AccountHistory(this.transactions,balance);
    }

/*    public AccountHistory getAccountHistory() {
        return null;
    }*/
}
