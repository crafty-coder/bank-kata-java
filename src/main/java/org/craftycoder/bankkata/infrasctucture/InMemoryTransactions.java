package org.craftycoder.bankkata.infrasctucture;

import org.craftycoder.bankkata.Transaction;
import org.craftycoder.bankkata.ports.Clock;
import org.craftycoder.bankkata.ports.Transactions;

import java.util.List;


public class InMemoryTransactions implements Transactions {
    public InMemoryTransactions(Clock clock) {
    }

    @Override
    public void register(int amount) {

    }

    @Override
    public List<Transaction> findAll() {
        return null;
    }
}
