package com.vera.zzl.calculator;
import com.vera.zzl.calculator.core.Elements;

import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Zhaolian on 26/04/2016.
 */
public class StringDivide {
    private static String Expression = "( 2 + 3 * 4 / 5 * ( 10 * 4))";
    private static StringTokenizer stringTokenizer;
    private static Stack<Character> operatorStack = new Stack<>();
    private static List<String> output = new Stack<>();

    public static List<String> Divide(String inputExpression){
        String number;
        stringTokenizer = new StringTokenizer(inputExpression);
        //Check if the input expression is valid
        if (Elements.isExpressionValid(inputExpression)){
            // do something
        }
        while (stringTokenizer.hasMoreTokens()){
            String currentToken = stringTokenizer.nextToken();
            char c = currentToken.charAt(0);
            if (Elements.isOperators(currentToken)){ //current token is an operator
                char o = operatorStack.peek();
                if ((Elements.opertatorAssociativity.get(c)== Elements.Associativity.Left &&
                        Elements.operatorPredence.get(c) <= Elements.operatorPredence.get(o))
                        ||
                        (Elements.opertatorAssociativity.get(c) == Elements.Associativity.Right&&
                                Elements.operatorPredence.get(c) < Elements.operatorPredence.get(o)))
                {
                    output.add(operatorStack.pop().toString());
                }
                operatorStack.push(c);
            }
            // open brace
            else if ( c == '('){
                operatorStack.push(c);
            }
            //close brace
            else if (c == ')'){
                boolean leftParenthesisFound = false;
                while (!operatorStack.isEmpty()){
                    char o = operatorStack.peek();
                    if ( o != '('){
                        output.add(operatorStack.pop().toString());
                    }
                    else{
                        operatorStack.pop();
                        leftParenthesisFound = true;
                        break;
                    }
                }
                if (!leftParenthesisFound){
                    //do something with the unmatched parentheses.
                    //throw Exception("The algebraic string contains mismatched parentheses (missing a left parenthesis).");
                }
            }
            else if (Elements.IsNumeric(currentToken)){  // number
                output.add(currentToken);
            }
        }

        while (!operatorStack.isEmpty()){
            char o = operatorStack.pop();
            if ( o == '('){
                //do something with the unmatched parentheses.
                //throw Exception("The algebraic string contains mismatched parentheses (extra a left parenthesis).");
            }
            else if (o == ')') {
                //do something with the unmatched parentheses.
                //throw Exception("The algebraic string contains mismatched parentheses (extra a right parenthesis).");
            }
            else{
                output.add(String.valueOf(o));
            }
        }

        return output;
    }

    public static void main(String[] args) {
        String testExpression = "( 2 + 3 ) * 5";
        List<String> result = Divide(testExpression);
        for (String c : result)
            System.out.println(c);
    }
}
