package org.craftycoder.bankkata.ports;

import org.craftycoder.bankkata.Statement;
import org.craftycoder.bankkata.Transaction;

import java.util.List;

public interface Printer {
    void print(Statement statement);
}
