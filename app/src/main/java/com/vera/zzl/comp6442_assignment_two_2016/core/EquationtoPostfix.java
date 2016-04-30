package com.vera.zzl.comp6442_assignment_two_2016.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Zhaolian on 26/04/2016.
 */
public class EquationtoPostfix {
    //Store the expression.
    private Stack<Expressions> expressionsStack = new Stack<>();
    private String infixExpression;
    private String postfixExpression;
    private Tokenizer infixTokenizer;
    private Stack<String> operatorStack = new Stack<>();
    private List<String> output = new ArrayList<>();
    private int currentPosition = 0;
    //private static char currentChar;
    public EquationtoPostfix(String str){
        infixExpression = str;
        infixTokenizer = new Tokenizer(str);
        Convert(infixTokenizer);
    }
    public List<String> Convert(Tokenizer myTokenizer){

        while (myTokenizer.hasMoreTokens()) {
            Object currentToken = myTokenizer.getCurrentToken();
            if (currentToken instanceof Float) {
                output.add(currentToken.toString());
            } else if (Elements.Operations.contains(currentToken.toString())) {
                if (!operatorStack.isEmpty()) {
                    String o = operatorStack.peek();
                    if (Elements.opertatorAssociativity.get(currentToken) == Elements.Associativity.Left &&
                            Elements.operatorPredence.get(currentToken) <= Elements.operatorPredence.get(o)
                            ||
                            (Elements.opertatorAssociativity.get(currentToken) == Elements.Associativity.Right &&
                                    Elements.operatorPredence.get(currentToken) < Elements.operatorPredence.get(o))) {
                        output.add(operatorStack.pop().toString());
                    }
                }
                operatorStack.push(currentToken.toString());
            } else if (currentToken.equals("(")) {
                //output.add(currentToken.toString());
                //operatorStack.push((String) currentToken);
            } else if (currentToken.equals(")")) {
                boolean leftParenthesisFound = false;
                while (!operatorStack.isEmpty()) {
                    String o = operatorStack.peek();
                    if (o != "(") {
                        output.add(operatorStack.pop().toString());
                    } else {
                        operatorStack.pop();
                        leftParenthesisFound = true;
                        break;
                    }
                }
                //output.add(currentToken.toString());
                if (!leftParenthesisFound) {
                    //do something with "The algebraic string contains mismatched parentheses (missing a left parenthesis)."
                    // throw new ParseException();
                } else {
                    //do something with "Unrecognized character '{0}'." Exception
                    //throw new Exception();
                }

            }
            myTokenizer.nextToken();
        }
        while (!operatorStack.isEmpty()){
            String o = operatorStack.pop();
            if (o == "("||o==")"){
                //do something
            }else {
                output.add(String.valueOf(o));
            }
        }
        return output;
    }

    public String toString(){
        String result = " ";
        for (String c : output){
            result = result+c + " ";
        }
        return result;
    }
}
