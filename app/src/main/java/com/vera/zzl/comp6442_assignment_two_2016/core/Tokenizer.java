package com.vera.zzl.comp6442_assignment_two_2016.core;

import com.vera.zzl.comp6442_assignment_two_2016.exceptions.ParseException;

/**
 * <h1>Addition</h1>
 * TODO Class Description
 *
 * @author Pubudu Dissanayake | comp6442_assignment_two_2016
 * @version 1.0
 * @since 26/04/2016
 */
public abstract class Tokenizer {

    abstract boolean hasNext();

    abstract Object current();

    abstract void next();

    public void parse(Object o) throws ParseException {
        if (current() == null || !current().equals(o))
            throw new ParseException();
        next();
    }
}
