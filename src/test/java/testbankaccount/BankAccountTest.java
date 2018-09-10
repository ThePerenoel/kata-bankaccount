package testbankaccount;

import bankaccount.BankAccount;
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
        void add_an_integer_to_a_list_of_transactions() {
            List<Integer> transactions = new ArrayList<>();
            BankAccount bankAccount = new BankAccount(transactions);

            bankAccount.deposit(10);

            assertThat(transactions).containsExactly(10);
        }

        @Test
        void add_multiple_integers_to_a_list_of_transactions() {
            List<Integer> transactions = new ArrayList<>();
            BankAccount bankAccount = new BankAccount(transactions);

            bankAccount.deposit(10);
            bankAccount.deposit(20);
            bankAccount.deposit(30);
            bankAccount.deposit(40);

            assertThat(transactions).hasSize(4);
        }




    }

}
