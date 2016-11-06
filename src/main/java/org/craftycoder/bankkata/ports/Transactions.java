package org.craftycoder.bankkata.ports;

import org.craftycoder.bankkata.domain.Statement;

public interface Transactions {
    void register(int amount);
    Statement generateStatement();
}
