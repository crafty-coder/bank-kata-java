package org.craftycoder.bankkata.infrasctucture;


import org.craftycoder.bankkata.Transaction;
import org.craftycoder.bankkata.ports.Clock;
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

    @Test public void
    contain_no_transactions_when_created(){
        List<Transaction> storedTransactions = transactions.findAll();

        assertThat(storedTransactions.size(),is(0));
    }

}