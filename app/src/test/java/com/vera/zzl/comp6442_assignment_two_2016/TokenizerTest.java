package com.vera.zzl.comp6442_assignment_two_2016;

import com.vera.zzl.comp6442_assignment_two_2016.core.Tokenizer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Zhaolian on 29/04/2016.
 */
public class TokenizerTest {
    @Test
    public void testGetToken_Correct(){
        String testExpressions[] = new String[]{"(+ 2 3)*5/4",
                                                "- 4 5",
                                                "21.0 - (3.5 *6.2)"};

        Tokenizer testTokenizer = new Tokenizer(testExpressions[0]);
        assertEquals(testTokenizer.getCurrentToken(),"(");
        testTokenizer.nextToken();
        assertEquals(testTokenizer.getCurrentToken(),"+");
        testTokenizer.nextToken();
        assertEquals(testTokenizer.getCurrentToken(),2.0f);
        testTokenizer.nextToken();
        assertEquals(testTokenizer.getCurrentToken(),3.0f);
        testTokenizer.nextToken();
        assertEquals(testTokenizer.getCurrentToken(),")");
        testTokenizer.nextToken();
        assertEquals(testTokenizer.getCurrentToken(),"*");
        testTokenizer.nextToken();
        assertEquals(testTokenizer.getCurrentToken(),5.0f);
        testTokenizer.nextToken();
        assertEquals(testTokenizer.getCurrentToken(),"/");
        testTokenizer.nextToken();
        assertEquals(testTokenizer.getCurrentToken(),4.0f);
    }
}
