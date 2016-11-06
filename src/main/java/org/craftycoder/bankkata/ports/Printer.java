package org.craftycoder.bankkata.ports;

import org.craftycoder.bankkata.Transaction;

import java.util.List;

public interface Printer {
    void print(List<Transaction> storedTransactions);
}
