package org.craftycoder.bankkata.infrastructure;

import org.craftycoder.bankkata.domain.Statement;
import org.craftycoder.bankkata.domain.Transaction;
import org.craftycoder.bankkata.ports.Writer;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class OutputPrinterShould {

    private Mockery context;
    private Writer writer;
    private OutputPrinter outputPrinter;

    @Before
    public void setUp() throws Exception {
        context = new Mockery();
        writer = context.mock(Writer.class);
        outputPrinter = new OutputPrinter(writer);
    }

    @Test
    public void print_the_header_of_the_statement(){

        context.checking(new Expectations(){{
            oneOf(writer).print("DATE       | AMOUNT  | BALANCE");
        }});

        outputPrinter.print(new Statement(new ArrayList<>()));

        context.assertIsSatisfied();

    }

    @Test
    public void print_the_full_statement_with_reverse_chronological_order(){

        context.checking(new Expectations(){{
            oneOf(writer).print("DATE       | AMOUNT  | BALANCE");
            oneOf(writer).print("02/05/2016 | -100.00  | 0.00");
            oneOf(writer).print("01/05/2016 | 100.00  | 100.00");
        }});

        Statement statement = new Statement(Arrays.asList(
                new Transaction("01/05/2016", 100),
                new Transaction("02/05/2016", -100)
        ));

        outputPrinter.print(statement);

        context.assertIsSatisfied();


    }

}