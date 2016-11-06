package org.craftycoder.bankkata.domain;

import org.craftycoder.bankkata.ports.Printer;
import org.craftycoder.bankkata.ports.Transactions;
import org.craftycoder.bankkata.ports.Writer;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class AccountShould {

    private Mockery context;
    private Writer writer;
    private Account account;
    private Transactions transactions;
    private Printer printer;

    @Before
    public void setUp() {
        context = new Mockery();
        writer = context.mock(Writer.class);
        transactions = context.mock(Transactions.class);
        printer = context.mock(Printer.class);
        account = new Account(transactions, printer);
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

        Statement statement = new Statement(Arrays.asList(
                new Transaction("01/05/2016", 100),
                new Transaction("02/05/2016", -100)
        ));

        context.checking(new Expectations() {{
            allowing(transactions).generateStatement();
            will(returnValue(statement));
            oneOf(printer).print(statement);
        }});

        account.printStatement();

        context.assertIsSatisfied();
    }

}