package org.craftycoder.bankkata.domain;

import org.craftycoder.bankkata.ports.Printer;
import org.craftycoder.bankkata.ports.Transactions;

public class Account {

    private Transactions transactions;
    private Printer printer;

    public Account(Transactions transactions, Printer printer) {
        this.transactions = transactions;
        this.printer = printer;
    }

    public void deposit(int amount) {
        transactions.register(amount);
    }

    public void withdraw(int amount) {
        transactions.register(-amount);
    }

    public void printStatement() {
        printer.print(transactions.generateStatement());
    }
}