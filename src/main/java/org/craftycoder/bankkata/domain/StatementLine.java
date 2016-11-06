package org.craftycoder.bankkata.domain;

public class StatementLine {

    public final Transaction transaction;
    public final int balance;

    public StatementLine(Transaction transaction, int balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatementLine that = (StatementLine) o;

        if (balance != that.balance) return false;
        return transaction != null ? transaction.equals(that.transaction) : that.transaction == null;

    }

    @Override
    public int hashCode() {
        int result = transaction != null ? transaction.hashCode() : 0;
        result = 31 * result + balance;
        return result;
    }

    @Override
    public String toString() {
        return "StatementLine{" +
                "transaction=" + transaction +
                ", balance=" + balance +
                '}';
    }
}
