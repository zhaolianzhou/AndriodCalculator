package com.vera.zzl.calculator;

import com.vera.zzl.calculator.core.EquationToPostfix;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Zhaolian on 29/04/2016.
 */
public class EquationtoPostfixTest {

    @Test
    public void testEquationtoPostfix(){
        String infixEquation[] = new String[]{"(2+3)/5*6",
                                                "4*6.5",
                                                "(8-6)*1.6"};
        ArrayList<String> postfixEquation = new ArrayList<>();

        for (int i = 0; i < infixEquation.length; i++ ){
            EquationToPostfix convert = new EquationToPostfix(infixEquation[i]);
            String result = convert.toString();
            postfixEquation.add(result);
        }
        assertEquals(postfixEquation.get(0)," 2.0 3.0 + 5.0 6.0 * / ");
        assertEquals(postfixEquation.get(1)," 4.0 6.5 * ");
        assertEquals(postfixEquation.get(2)," 8.0 6.0 - 1.6 * ");
    }
}
