package bankaccount;

import java.time.LocalDate;
import java.util.List;

public class BankAccount {
    private List<AccountStatement> statements;

    public BankAccount(List<AccountStatement> statements) {
        this.statements = statements;
    }

    public void deposit(MoneyAmount moneyAmount, LocalDate date) {
        AccountStatement statement = new AccountStatement("DEPOSIT",date, moneyAmount);
        this.statements.add(statement);
    }

    public void withdraw(MoneyAmount moneyAmount, LocalDate date) {
        AccountStatement statement = new AccountStatement("WITHDRAWAL", date, moneyAmount.getOpposite());
        this.statements.add(statement);
    }
}
