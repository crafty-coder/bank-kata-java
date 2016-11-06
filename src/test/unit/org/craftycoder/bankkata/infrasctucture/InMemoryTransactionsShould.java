package org.craftycoder.bankkata.infrasctucture;


import org.craftycoder.bankkata.Transaction;
import org.craftycoder.bankkata.ports.Clock;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class InMemoryTransactionsShould {

    private Mockery context;
    private InMemoryTransactions transactions;
    private Clock clock;


    @Before
    public void setUp() throws Exception {
        context = new Mockery();
        clock = context.mock(Clock.class);
        transactions = new InMemoryTransactions(clock);

    }

    @Test
    public void
    contain_no_transactions_when_created() {
        List<Transaction> storedTransactions = transactions.findAll();

        assertThat(storedTransactions.size(), is(0));
    }

    @Test
    public void
    contain_all_the_transactions_registered() {

        context.checking(new Expectations() {{
            allowing(clock).today();  will(onConsecutiveCalls(returnValue("01/12/2016"),returnValue("02/12/2016")));
        }});

        transactions.register(100);
        transactions.register(-100);

        List<Transaction> storedTransactions = transactions.findAll();

        assertThat(storedTransactions.size(), is(2));
        assertThat(storedTransactions.get(0), is(new Transaction("01/12/2016",100)));
        assertThat(storedTransactions.get(1), is(new Transaction("02/12/2016",-100)));
    }

}