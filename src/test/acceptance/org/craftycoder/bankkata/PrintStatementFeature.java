package org.craftycoder.bankkata;

import org.craftycoder.bankkata.infrasctucture.InMemoryTransactions;
import org.craftycoder.bankkata.ports.Clock;
import org.craftycoder.bankkata.ports.Output;
import org.craftycoder.bankkata.ports.Printer;
import org.craftycoder.bankkata.ports.Transactions;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class PrintStatementFeature {

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
        printer = context.mock(Printer.class);
        clock = context.mock(Clock.class);
        transactions = new InMemoryTransactions(clock);
        account = new Account(transactions, printer, output, clock);
    }

    @Test
    public void
    print_statement_with_all_transactions_in_chronological_order() {

        context.checking(new Expectations() {{

            allowing(clock).today(); will(onConsecutiveCalls(
                    returnValue("01/04/2014"),
                    returnValue("02/04/2014"),
                    returnValue("10/04/2014")
            ));

            oneOf(output).print("DATE       | AMOUNT  | BALANCE");
            oneOf(output).print("10/04/2014 | 500.00  | 1400.00");
            oneOf(output).print("02/04/2014 | -100.00 | 900.00");
            oneOf(output).print("01/04/2014 | 1000.00 | 1000.00");
        }});


        account.deposit(1000);
        account.withdraw(100);
        account.deposit(100);

        account.printStatement();

        context.assertIsSatisfied();

    }


}