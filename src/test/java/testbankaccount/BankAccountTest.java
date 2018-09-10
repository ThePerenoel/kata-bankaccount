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
            List<MoneyAmount> transactions2 = new ArrayList<>();
            BankAccount bankAccount = new BankAccount(transactions2);

            bankAccount.deposit(new MoneyAmount(10));

            assertThat(transactions2).contains(new MoneyAmount(10));
        }

        @Test
        void add_multiple_amounts_to_a_list_of_transactions() {
            List<MoneyAmount> transactions2 = new ArrayList<>();
            BankAccount bankAccount = new BankAccount(transactions2);

            bankAccount.deposit(new MoneyAmount(10));
            bankAccount.deposit(new MoneyAmount(20));
            bankAccount.deposit(new MoneyAmount(30));
            bankAccount.deposit(new MoneyAmount(40));

            assertThat(transactions2).hasSize(4);
        }


    }

}
