package org.craftycoder.bankkata.infrastructure;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConsoleShould {

    @Test
    public void write_into_the_output_stream() {

        OutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new PrintStream(outputStream));
        String textToPrint = "hello world!";
        String expectedText = "hello world!\n";

        console.print(textToPrint);

        assertThat(outputStream.toString(), is(expectedText));
    }

}