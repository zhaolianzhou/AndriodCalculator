package com.vera.zzl.calculator.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.vera.zzl.calculator.Operation.Number;

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
    private List<Object> output = new ArrayList<>();
    private int currentPosition = 0;
    //private static char currentChar;
    public EquationtoPostfix(String str){
        infixExpression = str;
        infixTokenizer = new Tokenizer(str);
        Convert(infixTokenizer);
    }
    public List<Object> Convert(Tokenizer myTokenizer){
        Boolean previousToken = true;
        while (myTokenizer.hasMoreTokens()) {
            Object currentToken = myTokenizer.getCurrentToken();
            if (currentToken.toString().equals("-")&& previousToken) {
                myTokenizer.nextToken();
                Object valueToken = myTokenizer.getCurrentToken();
                if (valueToken instanceof Float) {
                    float v = (float)(valueToken) *(-1);
                    Expressions number = new Number(v);
                    output.add(number);
                    previousToken = false;
                } else {
                    System.err.println("Invalid Expression");
                    break;
                }
            }else if (currentToken.toString().equals("+")&&previousToken){
                myTokenizer.nextToken();
                Object valueToken = myTokenizer.getCurrentToken();
                if (valueToken instanceof Float) {
                    float v = (float)(valueToken);
                    Expressions number = new Number(v);
                    output.add(number);
                    previousToken = false;
                } else {
                    System.err.println("Invalid Expression");
                    break;
                }
            }else{
                if (currentToken instanceof Float) {
                    float v = (float)(currentToken);
                    Expressions number = new Number(v);
                    output.add(number);
                    previousToken = false;
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
                    previousToken = true;
                } else if (currentToken.equals("(")) {
                    previousToken = true;
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
        for (Object c : output){
            result = result+c + " ";
        }
        return result;
    }
}
