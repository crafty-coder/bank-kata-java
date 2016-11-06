package org.craftycoder.bankkata.infrasctucture;

import org.craftycoder.bankkata.Statement;
import org.craftycoder.bankkata.Transaction;
import org.craftycoder.bankkata.ports.Output;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class OutputPrinterShould {

    private Mockery context;
    private Output output;
    private OutputPrinter outputPrinter;

    @Before
    public void setUp() throws Exception {
        context = new Mockery();
        output = context.mock(Output.class);
        outputPrinter = new OutputPrinter(output);
    }

    @Test
    public void print_the_header_of_the_statement(){

        context.checking(new Expectations(){{
            oneOf(output).print("DATE       | AMOUNT  | BALANCE");
        }});

        outputPrinter.print(new Statement(new ArrayList<>()));

        context.assertIsSatisfied();

    }

    @Test
    public void print_the_full_statement_with_reverse_chronological_order(){

        context.checking(new Expectations(){{
            oneOf(output).print("DATE       | AMOUNT  | BALANCE");
            oneOf(output).print("02/05/2016 | -100.00  | 0.00");
            oneOf(output).print("01/05/2016 | 100.00  | 100.00");
        }});

        Statement statement = new Statement(Arrays.asList(
                new Transaction("01/05/2016", 100),
                new Transaction("02/05/2016", -100)
        ));

        outputPrinter.print(statement);

        context.assertIsSatisfied();


    }

}