package com.vera.zzl.comp6442_assignment_two_2016.core;

import com.vera.zzl.comp6442_assignment_two_2016.exceptions.ParseException;

/**
 * <h1>Addition</h1>
 * TODO Class Description
 *      <exp> ::= <number> | <binop> <exp> <exp>
 *      <binop> ::= + | - | * | /
 *
 * @author Pubudu Dissanayake | comp6442_assignment_two_2016
 * @version 1.0
 * @since 26/04/2016
 */
public abstract class Expression {

    /*  This method prints an expression as a string
        (which could be parsed back into a expression) */
    public abstract String show();

    /* This method evaluates the expression */
    public abstract double evaluate();



    public static Expression parse(Tokenizer tok) throws ParseException {
        return null;
    }

}
