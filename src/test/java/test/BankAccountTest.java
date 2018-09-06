package test;

import bankaccount.BankAccount;
import bankaccount.BankOperation;
import bankaccount.TestTransactions;
import bankaccount.Transactions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

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

    @Nested
    @DisplayName("withdraw method should")
    class WithdrawMethodShould {

        @Test
        void add_minus_30_to_its_transactions_when_given_30() {

            Transactions bankAccountTransactions = new TestTransactions();
            BankAccount bankAccount = new BankAccount(bankAccountTransactions);
            Transactions testTransactions = new TestTransactions();

            bankAccount.withdraw(30);
            testTransactions.add(-30);

            assertThat(bankAccountTransactions).isEqualTo(testTransactions);
        }

        @Test
        void add_minus_30_and_minus_20_to_its_transactions_when_given_30_and_20() {

            Transactions bankAccountTransactions = new TestTransactions();
            BankAccount bankAccount = new BankAccount(bankAccountTransactions);
            Transactions testTransactions = new TestTransactions();

            bankAccount.withdraw(30);
            bankAccount.withdraw(20);
            testTransactions.add(-30);
            testTransactions.add(-20);

            assertThat(bankAccountTransactions).isEqualTo(testTransactions);
        }

    }

    @Nested
    @DisplayName("depositWithDate method should")
    class DepositWithDate {

        @Test
        void add_one_BankOperation_to_its_Transactions() {

            Transactions bankAccountTransactions = new TestTransactions();
            BankAccount bankAccount = new BankAccount(bankAccountTransactions);
            Transactions testTransactions = new TestTransactions();
            BankOperation bankOperation = new BankOperation("DEPOSIT", 30, LocalTime.of(10,0));

            bankAccount.depositWithDate(bankOperation);
            testTransactions.add(bankOperation);

            assertThat(bankAccountTransactions).isEqualTo(testTransactions);

        }

        @Test
        void add_several_BankOperation_to_its_Transactions() {

            Transactions bankAccountTransactions = new TestTransactions();
            BankAccount bankAccount = new BankAccount(bankAccountTransactions);
            Transactions testTransactions = new TestTransactions();
            BankOperation bankOperation = new BankOperation("DEPOSIT", 30, LocalTime.of(10,0));
            BankOperation bankOperation2 = new BankOperation("DEPOSIT", 20, LocalTime.of(11,0));
            BankOperation bankOperation3 = new BankOperation("DEPOSIT", 40, LocalTime.of(12,0));

            bankAccount.depositWithDate(bankOperation);
            bankAccount.depositWithDate(bankOperation2);
            bankAccount.depositWithDate(bankOperation3);
            testTransactions.add(bankOperation);
            testTransactions.add(bankOperation2);
            testTransactions.add(bankOperation3);

            assertThat(bankAccountTransactions).isEqualTo(testTransactions);

        }

    }


}
