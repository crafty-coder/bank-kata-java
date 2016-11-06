package org.craftycoder.bankkata.ports;

import org.craftycoder.bankkata.Statement;
import org.craftycoder.bankkata.Transaction;

import java.util.List;

public interface Transactions {
    void register(int amount);
    @Deprecated
    List<Transaction> findAll();
    Statement generateStatement();
}
