package com.vera.zzl.comp6442_assignment_two_2016.core;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Zhaolian on 26/04/2016.
 */
public class Elements {
    public static String Numbers = "0123456789";
    public static String Operations = "+-*/";
    public static String Brackets = "()";
    public static final char whiteSpace[] = {' ','\n','\t','\r','f'};
    public static String AllowedCharacters = Numbers+Operations+Brackets+" ";



    public enum Associativity{Left, Right}
    //The associativity of the operators.
    public static HashMap<String, Associativity> opertatorAssociativity = new HashMap<>();
    public static HashMap<String,Integer> operatorPredence = new HashMap<>();
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
        opertatorAssociativity.put("+", Associativity.Left);
        opertatorAssociativity.put("-", Associativity.Left);
        opertatorAssociativity.put("*", Associativity.Left);
        opertatorAssociativity.put("/", Associativity.Left);
        opertatorAssociativity.put("^", Associativity.Right);
    }

    public static void setOperatorPredence(){
        operatorPredence.put("(",0);
        operatorPredence.put(")",0);
        operatorPredence.put("+",1);
        operatorPredence.put("-",1);
        operatorPredence.put("*",2);
        operatorPredence.put("/",2);
        operatorPredence.put("^",3);

    }
}
