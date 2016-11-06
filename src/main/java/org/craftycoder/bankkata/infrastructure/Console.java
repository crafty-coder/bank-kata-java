package org.craftycoder.bankkata.infrastructure;

import org.craftycoder.bankkata.ports.Writer;

import java.io.PrintStream;

public class Console implements Writer {

    private final PrintStream printStream;

    public Console(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void print(String text) {
        printStream.println(text);
    }
}

