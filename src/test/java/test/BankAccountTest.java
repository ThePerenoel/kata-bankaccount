package test;

import bankaccount.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

    @Nested
    @DisplayName("depositWithDate method should")
    class DepositWithDate {

        @Test
        void add_one_BankOperation_to_its_Transactions() {

            Transactions bankAccountTransactions = new TestTransactions();
            BankAccount bankAccount = new BankAccount(bankAccountTransactions);
            Transactions testTransactions = new TestTransactions();
            BankOperation bankOperation = new BankOperation("DEPOSIT", 30, LocalTime.of(10,0));

            bankAccount.depositWithDate(30, LocalTime.of(10,0));
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

            bankAccount.depositWithDate(30, LocalTime.of(10,0));
            bankAccount.depositWithDate(20, LocalTime.of(11,0));
            bankAccount.depositWithDate(40, LocalTime.of(12,0));
            testTransactions.add(bankOperation);
            testTransactions.add(bankOperation2);
            testTransactions.add(bankOperation3);

            assertThat(bankAccountTransactions).isEqualTo(testTransactions);

        }

    }

    @Nested
    @DisplayName("withdrawWithDate method should")
    class WithdrawWithDate {

        @Test
        void add_one_BankOperation_to_its_Transactions() {

            Transactions bankAccountTransactions = new TestTransactions();
            BankAccount bankAccount = new BankAccount(bankAccountTransactions);
            Transactions testTransactions = new TestTransactions();
            BankOperation bankOperation = new BankOperation("WITHDRAWAL", -30, LocalTime.of(10,0));

            bankAccount.withdrawWithDate(-30, LocalTime.of(10,0));
            testTransactions.add(bankOperation);

            assertThat(bankAccountTransactions).isEqualTo(testTransactions);

        }

        @Test
        void add_several_BankOperation_to_its_Transactions() {

            Transactions bankAccountTransactions = new TestTransactions();
            BankAccount bankAccount = new BankAccount(bankAccountTransactions);
            Transactions testTransactions = new TestTransactions();
            BankOperation bankOperation = new BankOperation("WITHDRAWAL", -30, LocalTime.of(10,0));
            BankOperation bankOperation2 = new BankOperation("WITHDRAWAL", -20, LocalTime.of(11,0));
            BankOperation bankOperation3 = new BankOperation("WITHDRAWAL", -40, LocalTime.of(12,0));

            bankAccount.withdrawWithDate(-30, LocalTime.of(10,0));
            bankAccount.withdrawWithDate(-20, LocalTime.of(11,0));
            bankAccount.withdrawWithDate(-40, LocalTime.of(12,0));
            testTransactions.add(bankOperation);
            testTransactions.add(bankOperation2);
            testTransactions.add(bankOperation3);

            assertThat(bankAccountTransactions).isEqualTo(testTransactions);

        }

    }
    @Nested
    @DisplayName("withdrawWithDate method should")
    class getHistory {

        @Test
        void return_history_with_all_operations_and_balance() {
            Transactions bankAccountTransactions = new TestTransactions();
            BankAccount bankAccount = new BankAccount(bankAccountTransactions);
            bankAccount.withdrawWithDate(-30, LocalTime.of(10,0));
            bankAccount.depositWithDate(20, LocalTime.of(11,0));
            bankAccount.withdrawWithDate(-40, LocalTime.of(12,0));

            Transactions testTransactions = new TestTransactions();
            BankOperation bankOperation = new BankOperation("WITHDRAWAL", -30, LocalTime.of(10,0));
            BankOperation bankOperation2 = new BankOperation("DEPOSIT", 20, LocalTime.of(11,0));
            BankOperation bankOperation3 = new BankOperation("WITHDRAWAL", -40, LocalTime.of(12,0));

            testTransactions.add(bankOperation);
            testTransactions.add(bankOperation2);
            testTransactions.add(bankOperation3);

            AccountHistory accountHistory = bankAccount.getAccountHistory();
            AccountHistory accountHistoryToCompare = new AccountHistory(testTransactions, testTransactions.sumAll());

            assertThat(accountHistory).isEqualTo(accountHistoryToCompare);

        }
    }

}
