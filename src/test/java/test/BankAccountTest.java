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
    @DisplayName("Deposit method should")
    class DepositTest {

        @Test
        void should_add_20_to_its_transactions_when_given_20() {
            Transactions bankAccountTransactions = new TestTransactions();
            BankAccount bankAccount = new BankAccount(bankAccountTransactions);
            Transactions testTransactions = new TestTransactions();

            bankAccount.deposit(20);
            testTransactions.add(20);

            assertThat(bankAccountTransactions).isEqualTo(testTransactions);
        }

    }

}
