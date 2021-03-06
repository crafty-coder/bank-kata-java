package org.craftycoder.bankkata;

import org.craftycoder.bankkata.domain.Account;
import org.craftycoder.bankkata.infrastructure.InMemoryTransactions;
import org.craftycoder.bankkata.infrastructure.OutputPrinter;
import org.craftycoder.bankkata.ports.Clock;
import org.craftycoder.bankkata.ports.Writer;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class PrintStatementFeature {

    private Mockery context;
    private Writer writer;
    private Clock clock;
    private Account account;

    @Before
    public void setUp() {
        context = new Mockery();
        writer = context.mock(Writer.class);
        clock = context.mock(Clock.class);
        account = new Account(
                new InMemoryTransactions(clock),
                new OutputPrinter(writer)
        );
    }

    @Test
    public void
    print_statement_with_all_transactions_in_reverse_chronological_order() {

        context.checking(new Expectations() {{

            allowing(clock).today();
            will(onConsecutiveCalls(
                    returnValue("01/04/2014"),
                    returnValue("02/04/2014"),
                    returnValue("10/04/2014")
            ));

            oneOf(writer).print("DATE       | AMOUNT  | BALANCE");
            oneOf(writer).print("10/04/2014 | 500.00  | 1400.00");
            oneOf(writer).print("02/04/2014 | -100.00  | 900.00");
            oneOf(writer).print("01/04/2014 | 1000.00  | 1000.00");
        }});


        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        context.assertIsSatisfied();

    }


}