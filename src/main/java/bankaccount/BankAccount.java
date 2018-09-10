package bankaccount;

import java.util.List;

public class BankAccount {
    private final List<Integer> transactions;

    public BankAccount(List<Integer> transactions) {

        this.transactions = transactions;
    }

    public void deposit(int amount) {
        transactions.add(amount);
    }
}
