package org.craftycoder.bankkata;

import org.craftycoder.bankkata.ports.Clock;
import org.craftycoder.bankkata.ports.Output;
import org.craftycoder.bankkata.ports.Transactions;

public class Account {

    private Output output;
    private Clock clock;
    private Transactions transactions;

    public Account(Transactions transactions, Output output, Clock clock) {
        this.output = output;
        this.clock = clock;
        this.transactions = transactions;
    }

    public void deposit(int amount) {
        transactions.register(amount);
    }

    public void withdraw(int amount) {
        transactions.register(-amount);
    }

    public void printStatement() {

    }
}