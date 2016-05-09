package com.vera.zzl.calculator.core;

import com.vera.zzl.calculator.Operation.*;
import com.vera.zzl.calculator.Operation.Number;
import com.vera.zzl.calculator.exceptions.ParseException;

import java.util.List;
import java.util.Stack;

/**
 * Created by Zhaolian on 25/04/2016.
 */

/**
 * <exp> ::= <number> | ( <binop> <exp> <exp> )
 *<binop> ::= + | - | * | /
 */
public abstract class Expressions {
    public Expressions(){};
    /*  This method prints an expression as a string
        (which could be parsed back into a expression) */
    public abstract String show();
    /* This method evaluates the expression */
    public abstract Object evaluate();

    private static Stack<Expressions> expressionsStack = new Stack<>();
    static public Expressions parse(Tokenizer myTokenizer) throws ParseException {

        /*  Add code that will parse the string
            creating the expression for that string */
        //Tokenizer myTokenizer = new Tokenizer(str);
        Object currentToken = myTokenizer.getCurrentToken();
        while (myTokenizer.hasMoreTokens()) {
            if ((currentToken instanceof Float)) {
                float v = (float) currentToken;
                myTokenizer.nextToken();
                Expressions number = new Number(v);
                expressionsStack.push(number);
            } else if (currentToken.equals("+")) {
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                myTokenizer.nextToken();
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Addition(lPara, rPara);
                expressionsStack.push(result);
            } else if (currentToken.equals("-")) {
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                myTokenizer.nextToken();
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Subtraction(lPara, rPara);
                expressionsStack.push(result);
            } else if (currentToken.equals("*")) {
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                myTokenizer.nextToken();
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Multiplication(lPara, rPara);
                expressionsStack.push(result);
            } else if (currentToken.equals("/")) {
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                myTokenizer.nextToken();
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Division(lPara, rPara);
                expressionsStack.push(result);
            } else if (currentToken.equals("%")){
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                myTokenizer.nextToken();
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Mod(lPara, rPara);
                expressionsStack.push(result);
            }else if (currentToken.equals("^")){
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Pow(lPara, rPara);
                expressionsStack.push(result);
            }else {
                throw new ParseException();
            }
            currentToken = myTokenizer.getCurrentToken();
        }
        Expressions expressionResult = expressionsStack.peek();
        return expressionResult;
    }

    static public Expressions parse(List<Object> outputStack) throws ParseException{
        for (Object currentToken: outputStack){
            if (currentToken instanceof Number){
                expressionsStack.push((Number)currentToken);
            }else if (currentToken.equals("+")){
                if (expressionsStack.size() < 2){
                    // do something
                }
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Addition(lPara, rPara);
                expressionsStack.push(result);
            }else if (currentToken.equals("-")){
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Subtraction(lPara, rPara);
                expressionsStack.push(result);
            } else if (currentToken.equals("*")) {
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Multiplication(lPara, rPara);
                expressionsStack.push(result);
            } else if (currentToken.equals("/")) {
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Division(lPara, rPara);
                expressionsStack.push(result);
            } else if (currentToken.equals("%")){
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Mod(lPara, rPara);
                expressionsStack.push(result);
            }else if (currentToken.equals("^")){
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Pow(lPara, rPara);
                expressionsStack.push(result);
            }else if (currentToken.equals("A")){
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new And(lPara, rPara);
                expressionsStack.push(result);
            }else if (currentToken.equals("O")){
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Or(lPara, rPara);
                expressionsStack.push(result);
            }
            else if (currentToken.equals("X")){
                if (expressionsStack.size() < 2) {
                    //do something with not enough paras.
                }
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Xor(lPara, rPara);
                expressionsStack.push(result);
            }else {
                throw new ParseException();
            }
        }
        Expressions expressionResult = expressionsStack.peek();
        return expressionResult;
    }
        /*  This is a place holder in order to get show
            and evaluate working first */

    static public int IsPositive(float number){
        float PositiveZero = 1E-7f;
        float NegativeZero = -1E-7f;
        if (Math.abs(number) < PositiveZero)
            return 0;
        else if (number >= PositiveZero)
            return 1;
        else
            return -1;
    }
}
