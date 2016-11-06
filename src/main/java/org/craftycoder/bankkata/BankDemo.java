package org.craftycoder.bankkata;

import org.craftycoder.bankkata.domain.Account;
import org.craftycoder.bankkata.infrastructure.Console;
import org.craftycoder.bankkata.infrastructure.InMemoryTransactions;
import org.craftycoder.bankkata.infrastructure.OutputPrinter;
import org.craftycoder.bankkata.infrastructure.SystemClock;

public class BankDemo {

    public static void main(String[] args) {

        Account account = new Account(
                new InMemoryTransactions(new SystemClock()),
                new OutputPrinter(new Console(System.out))
        );

        account.deposit(1000);
        account.withdraw(900);
        account.deposit(2000);

        account.printStatement();
    }
}
