package org.craftycoder.bankkata.infrastructure;

import org.craftycoder.bankkata.ports.Output;

public class SystemOutput implements Output {

    @Override
    public void print(String line) {
        System.out.println(line);
    }
}
