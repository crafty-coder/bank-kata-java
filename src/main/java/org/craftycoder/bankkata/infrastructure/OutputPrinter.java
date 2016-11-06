package org.craftycoder.bankkata.infrastructure;

import org.craftycoder.bankkata.Statement;
import org.craftycoder.bankkata.StatementLine;
import org.craftycoder.bankkata.ports.Writer;
import org.craftycoder.bankkata.ports.Printer;

import java.util.ArrayList;
import java.util.Collections;

public class OutputPrinter implements Printer {

    private static final String HEADER = "DATE       | AMOUNT  | BALANCE";
    private static final String SEPARATOR_1 = " | ";
    private static final String SEPARATOR_2 = "  | ";
    private Writer writer;

    public OutputPrinter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void print(Statement statement) {
        printHeader();
        printStatementLines(statement);
    }

    private void printStatementLines(Statement statement) {
        ArrayList<StatementLine> StatementLines = getStatementLinesInChronologicalOrder(statement);

        StatementLines.stream()
                .map(this::statementLineToString)
                .forEachOrdered(writer::print);
    }

    private ArrayList<StatementLine> getStatementLinesInChronologicalOrder(Statement statement) {
        final ArrayList<StatementLine> reversedList = new ArrayList<>(statement.statementLines);
        Collections.reverse(reversedList);
        return reversedList;
    }

    private String statementLineToString(StatementLine statementLine) {
        return statementLine.transaction.date +
                SEPARATOR_1 +
                toPrintableString(statementLine.transaction.amount) +
                SEPARATOR_2 +
                toPrintableString(statementLine.balance);

    }

    private String toPrintableString(Integer amount) {
        return amount + ".00";
    }

    private void printHeader() {
        writer.print(HEADER);
    }
}
