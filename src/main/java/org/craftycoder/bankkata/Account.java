package org.craftycoder.bankkata;

import org.craftycoder.bankkata.ports.Clock;
import org.craftycoder.bankkata.ports.Output;

public class Account {

    private Output output;
    private Clock clock;

    public Account(Output output, Clock clock) {
        this.output = output;
        this.clock = clock;
    }

    public void deposit(int amount) {

    }

    public void withdraw(int amount) {

    }

    public void printStatement() {

    }
}