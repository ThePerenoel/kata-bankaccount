package testbankaccount;

import bankaccount.AccountStatement;
import bankaccount.BankAccount;
import bankaccount.MoneyAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

    @Nested
    @DisplayName("Deposit method should")
    class DepositShould {

        @Test
        void add_a_statement_typed_DEPOSIT_to_a_list_of_statements() {
            List<AccountStatement> statements = new ArrayList<>();
            BankAccount bankAccount = new BankAccount(statements);

            bankAccount.deposit(new MoneyAmount(10), LocalDate.of(2018,01,01));

            assertThat(statements).contains(new AccountStatement("DEPOSIT", LocalDate.of(2018,01,01), new MoneyAmount(10)));
        }

        @Test
        void add_multiple_statements_typed_DEPOSIT_to_a_list_of_statements() {
            List<AccountStatement> statements = new ArrayList<>();
            BankAccount bankAccount = new BankAccount(statements);

            bankAccount.deposit(new MoneyAmount(10), LocalDate.of(2018,01,01));
            bankAccount.deposit(new MoneyAmount(20), LocalDate.of(2018,02,01));
            bankAccount.deposit(new MoneyAmount(30), LocalDate.of(2018,03,01));

            assertThat(statements).hasSize(3);
        }

    }

    @Nested
    @DisplayName("Withdraw method should")
    class WithdrawShould {

        @Test
        void add_a_statement_typed_WITHDRAWAL_to_a_list_of_statements() {
            List<MoneyAmount> transactions = new ArrayList<>();
            List<AccountStatement> statements = new ArrayList<>();
            BankAccount bankAccount = new BankAccount(statements);

            bankAccount.withdraw(new MoneyAmount(10), LocalDate.of(2018,01,01));

            assertThat(statements).contains(new AccountStatement("WITHDRAWAL", LocalDate.of(2018,01,01), new MoneyAmount(-10)));
        }

    }

}
