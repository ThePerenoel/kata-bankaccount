package testbankaccount;

import bankaccount.BankAccount;
import bankaccount.MoneyAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

    @Nested
    @DisplayName("Deposit method should")
    class DepositShould {

        @Test
        void add_an_amount_to_a_list_of_transactions() {
            List<MoneyAmount> transactions = new ArrayList<>();
            BankAccount bankAccount = new BankAccount(transactions);

            bankAccount.deposit(new MoneyAmount(10));

            assertThat(transactions).contains(new MoneyAmount(10));
        }

        @Test
        void add_multiple_amounts_to_a_list_of_transactions() {
            List<MoneyAmount> transactions = new ArrayList<>();
            BankAccount bankAccount = new BankAccount(transactions);

            bankAccount.deposit(new MoneyAmount(10));
            bankAccount.deposit(new MoneyAmount(20));
            bankAccount.deposit(new MoneyAmount(30));
            bankAccount.deposit(new MoneyAmount(40));

            assertThat(transactions).hasSize(4);
        }

    }

    @Nested
    @DisplayName("Withdraw method should")
    class WithdrawShould {

        @Test
        void add_a_negative_amount_to_a_list_of_transactions() {
            List<MoneyAmount> transactions = new ArrayList<>();
            BankAccount bankAccount = new BankAccount(transactions);

            bankAccount.withdraw(new MoneyAmount(10));

            assertThat(transactions).contains(new MoneyAmount(-10));
        }

    }

}
