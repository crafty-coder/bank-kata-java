package org.craftycoder.bankkata;

import java.util.Collections;
import java.util.List;

public class Statement {

   public final List<StatementLine> statementLines;

    public Statement(List<StatementLine> statementLines) {
        this.statementLines = Collections.unmodifiableList(statementLines);
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
