package org.craftycoder.bankkata;

import org.craftycoder.bankkata.ports.Clock;
import org.craftycoder.bankkata.ports.Output;
import org.craftycoder.bankkata.ports.Printer;
import org.craftycoder.bankkata.ports.Transactions;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AccountShould {

    private Mockery context;
    private Output output;
    private Clock clock;
    private Account account;
    private Transactions transactions;
    private Printer printer;

    @Before
    public void setUp() {
        context = new Mockery();
        output = context.mock(Output.class);
        clock = context.mock(Clock.class);
        transactions = context.mock(Transactions.class);
        printer = context.mock(Printer.class);
        account = new Account(transactions, printer, output, clock);
    }

    @Test
    public void
    register_deposits() {

        context.checking(new Expectations() {{
            oneOf(transactions).register(100);
        }});

        account.deposit(100);

        context.assertIsSatisfied();
    }

    @Test
    public void
    register_withdraw() {

        context.checking(new Expectations() {{
            oneOf(transactions).register(-100);
        }});

        account.withdraw(100);

        context.assertIsSatisfied();
    }

    @Test
    public void
    print_transactions() {

        List<Transaction> storedTransactions = Arrays.asList(
                new Transaction("01/05/2016", 100),
                new Transaction("02/05/2016", -100)
        );

        context.checking(new Expectations() {{
            allowing(transactions).findAll();
            will(returnValue(storedTransactions));
            oneOf(printer).print(storedTransactions);
        }});

        account.printStatement();

        context.assertIsSatisfied();
    }

}