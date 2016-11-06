package org.craftycoder.bankkata.infrastructure;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SystemClockShould {

    @Test public void
    return_todays_date_in_ddmmyyyy_format(){

        SystemClock clock = new SystemClockFake();
        String today = clock.today();

        assertThat(today,is("02/12/2016"));
    }


    class SystemClockFake extends SystemClock{
        @Override
        protected LocalDate now() {
            return LocalDate.of(2016,12,2);
        }
    }
}