package org.craftycoder.bankkata;

import org.craftycoder.bankkata.ports.Clock;
import org.craftycoder.bankkata.ports.Output;
import org.craftycoder.bankkata.ports.Transactions;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class AccountShould {

    private Mockery context;
    private Output output;
    private Clock clock;
    private Account account;
    private Transactions transactions;

    @Before
    public void setUp() {
        context = new Mockery();
        output = context.mock(Output.class);
        clock = context.mock(Clock.class);
        transactions = context.mock(Transactions.class);
        account = new Account(transactions, output, clock);
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




}