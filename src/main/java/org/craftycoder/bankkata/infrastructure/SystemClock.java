package org.craftycoder.bankkata.infrastructure;

import org.craftycoder.bankkata.ports.Clock;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SystemClock implements Clock {

    @Override
    public String today() {
        LocalDate today = now();
        return format(today);
    }

    private String format(LocalDate today) {
        return today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    protected LocalDate now() {
        return LocalDate.now();
    }
}
