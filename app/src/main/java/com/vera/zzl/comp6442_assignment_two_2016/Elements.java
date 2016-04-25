package com.vera.zzl.comp6442_assignment_two_2016;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Zhaolian on 24/04/2016.
 * Reference URL: http://www.csharpprogramming.tips/2015/12/infix-notation-parser-via-shunting-yard.html
 */
public class Elements {
    public static String Numbers = "0123456789";
    public static String Operations = "+-*/";
    public static String Brackets = "()";
    public static String AllowedCharacters = Numbers+Operations+Brackets;

    public enum Associativity{Left, Right}
    //The associativity of the operators.
    public static HashMap<Character, Associativity> opertatorAssociativity = new HashMap<Character, Associativity>();
    public static HashMap<Character,Integer> operatorPredence = new HashMap<>();
    public static boolean IsNumeric(String text){
        for (char c : text.toCharArray()){
            if (!Numbers.contains(String.valueOf(c)))
                return false;
        }
        return true;
    }

    public static boolean isOperators(String text){
        if (text.length() != 1)
            return false;
        for (char c : text.toCharArray()){
            if (!Operations.contains(String.valueOf(c)));
            return false;
        }
        return true;
    }

    public static boolean isExpressionValid(String expression) {
        StringTokenizer stringTokenizer = new StringTokenizer(expression);
        while (stringTokenizer.hasMoreTokens()) {
            for (char c : stringTokenizer.nextToken().toCharArray()) {
                if (!AllowedCharacters.contains(String.valueOf(c)))
                    return false;
            }
        }
        return true;
    }

    public static void setOperatorAssociate(){
        opertatorAssociativity.put('+', Associativity.Left);
        opertatorAssociativity.put('-', Associativity.Left);
        opertatorAssociativity.put('*', Associativity.Left);
        opertatorAssociativity.put('/', Associativity.Left);
        opertatorAssociativity.put('^', Associativity.Right);
    }

    public static void setOperatorPredence(){
        operatorPredence.put('(',0);
        operatorPredence.put(')',0);
        operatorPredence.put('+',1);
        operatorPredence.put('-',1);
        operatorPredence.put('*',2);
        operatorPredence.put('/',2);
        operatorPredence.put('^',3);

    }
}
