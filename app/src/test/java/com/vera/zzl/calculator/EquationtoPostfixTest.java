package com.vera.zzl.calculator;

import com.vera.zzl.calculator.core.EquationtoPostfix;
import com.vera.zzl.calculator.core.Expressions;
import com.vera.zzl.calculator.core.Tokenizer;
import com.vera.zzl.calculator.exceptions.ParseException;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Zhaolian on 29/04/2016.
 */
public class EquationtoPostfixTest {

    @Test
    public void testEquationtoPostfix() throws ParseException {
        String infixEquation[] = new String[]{"(2+3)/5*6",
                                                "4*6.5",
                                                "(8-6)*1.6"};
        List<Expressions> postfixEquation = new ArrayList<>();
        Expressions result = null;
        for (int i = 0; i < infixEquation.length; i++ ){
            EquationtoPostfix convert = new EquationtoPostfix(infixEquation[i]);
            Tokenizer infixToken = new Tokenizer(infixEquation[i]);
            List<Object> poxtfix = convert.Convert(infixToken);
            result = Expressions.parse(poxtfix);
            postfixEquation.add(result);
            //postfixEquation.add(finalString);
        }
        assertEquals(postfixEquation.get(0).show(),"( ( 2.0 3.0 +) ( 5.0 6.0 *) /)");
        assertEquals(postfixEquation.get(1).show(),"( 4.0 6.5 *)");
        assertEquals(postfixEquation.get(2).show(),"( ( 8.0 6.0 - ) 1.6 *)");
    }
}
