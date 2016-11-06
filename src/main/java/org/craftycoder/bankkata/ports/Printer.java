package org.craftycoder.bankkata.ports;

import org.craftycoder.bankkata.domain.Statement;

public interface Printer {
    void print(Statement statement);
}
