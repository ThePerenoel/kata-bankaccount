package test;

import bankaccount.BankAccount;
import bankaccount.TestTransactions;
import bankaccount.Transactions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

    @Nested
    @DisplayName("deposit method should")
    class DepositTest {

        @Test
        void add_20_to_its_transactions_when_given_20() {
            Transactions bankAccountTransactions = new TestTransactions();
            BankAccount bankAccount = new BankAccount(bankAccountTransactions);
            Transactions testTransactions = new TestTransactions();

            bankAccount.deposit(20);
            testTransactions.add(20);

            assertThat(bankAccountTransactions).isEqualTo(testTransactions);
        }

        @Test
        void add_20_and_30_to_its_transactions_when_given_20_and_30() {
            Transactions bankAccountTransactions = new TestTransactions();
            BankAccount bankAccount = new BankAccount(bankAccountTransactions);
            Transactions testTransactions = new TestTransactions();

            bankAccount.deposit(20);
            bankAccount.deposit(30);
            testTransactions.add(20);
            testTransactions.add(30);

            assertThat(bankAccountTransactions).isEqualTo(testTransactions);
        }

    }

}
