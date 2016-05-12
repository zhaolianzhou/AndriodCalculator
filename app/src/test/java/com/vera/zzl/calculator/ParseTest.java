package com.vera.zzl.calculator;

import com.vera.zzl.calculator.core.EquationtoPostfix;
import com.vera.zzl.calculator.core.Expressions;
import com.vera.zzl.calculator.core.Tokenizer;
import com.vera.zzl.calculator.exceptions.ParseException;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Zhaolian on 29/04/2016.
 */
public class ParseTest {

    @Test
    public void testExpressionsParse(){
        String testExpressions[] = new String[]{"(+ 2 3)*5/4",
                "- 4 5",
                "21.0 - (3.5 *6.2)"};

        ArrayList<String> postfixEquation = new ArrayList<>();
        ArrayList<Tokenizer> postfixTokenizer = new ArrayList<>();

        for(int i = 0; i < testExpressions.length; i++){
            EquationtoPostfix convert = new EquationtoPostfix(testExpressions[i]);
            postfixEquation.add(convert.toString());
            postfixTokenizer.add(new Tokenizer(postfixEquation.get(i)));
        }

        for (int i = 0; i < postfixTokenizer.size(); i++){
            try {
                Expressions result = Expressions.parse(postfixTokenizer.get(0));
               // assertTrue(result.evaluate() == 6.25f);
            } catch (ParseException e){

            }

        }
    }

}
