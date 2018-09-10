package bankaccount;

import java.util.List;

public class BankAccount {
    private final List<MoneyAmount> transactions;

    public BankAccount(List<MoneyAmount> transactions) {
        this.transactions = transactions;
    }

    public void deposit(MoneyAmount moneyAmount) {
        transactions.add(moneyAmount);
    }

    public void withdraw(MoneyAmount moneyAmount) {
        transactions.add(moneyAmount.getOpposite());
    }
}
