package com.sample.hateoas.core.entities.auditing;

import org.springframework.data.auditing.DateTimeProvider;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by andresmerida on 4/4/2016.
 */

public class DateTimeProviderImpl implements DateTimeProvider {

    @Override
    public Calendar getNow(){
        return new GregorianCalendar();
    }
}
