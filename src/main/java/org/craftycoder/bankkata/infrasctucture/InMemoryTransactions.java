package org.craftycoder.bankkata.infrasctucture;

import org.craftycoder.bankkata.Statement;
import org.craftycoder.bankkata.Transaction;
import org.craftycoder.bankkata.ports.Clock;
import org.craftycoder.bankkata.ports.Transactions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class InMemoryTransactions implements Transactions {

    private Clock clock;
    private List<Transaction> storedTransactions;

    public InMemoryTransactions(Clock clock) {
        this.clock = clock;
        storedTransactions = new ArrayList<>();
    }

    @Override
    public void register(int amount) {
        storedTransactions.add(new Transaction(clock.today(),amount));
    }

    @Override
    public List<Transaction> findAll() {
        return Collections.unmodifiableList(storedTransactions);
    }

    @Override
    public Statement generateStatement() {
        return new Statement(new ArrayList<>());
    }


}
