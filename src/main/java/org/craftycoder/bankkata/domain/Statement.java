package org.craftycoder.bankkata.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statement {

    private static final int INITIAL_BALANCE = 0;
    public final List<StatementLine> statementLines;

    public Statement(List<Transaction> transactions) {
        this.statementLines = getStatementLines(transactions);
    }

    private List<StatementLine> getStatementLines(List<Transaction> transactions) {
        List<StatementLine> statementLines = new ArrayList<>();
        int balance = INITIAL_BALANCE;
        for (Transaction transaction : transactions) {
            balance += transaction.amount;
            statementLines.add(new StatementLine(transaction, balance));
        }
        return Collections.unmodifiableList(statementLines);
   }

    @Override
    public String toString() {
        return "Statement{" +
                "statementLines=" + statementLines +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statement statement = (Statement) o;

        return statementLines != null ? statementLines.equals(statement.statementLines) : statement.statementLines == null;

    }

    @Override
    public int hashCode() {
        return statementLines != null ? statementLines.hashCode() : 0;
    }
}
