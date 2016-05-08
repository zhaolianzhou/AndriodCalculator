package com.vera.zzl.comp6442_assignment_two_2016.core;

import com.vera.zzl.comp6442_assignment_two_2016.exceptions.ParseException;
/**
 * Created by Zhaolian on 25/04/2016.
 */
public class Tokenizer {
    public static String Numbers = "012345678";
    public static String Decimal = ".";
    public static String Operations = "+-*/%()^";
    public static final char whitespace[] = {' ', '\n', '\t','\r','\f'};
    public static String ValidFloat = Numbers + Decimal;
    public static String AllowedCharacters = Numbers+Operations+Decimal+" ";

    private String inputString = "";
    private static char currentChar;
    private static Object currentToken = " ";
    private int currentPosition = 0;
    /**
     * Constructs a string tokenizer for the specified string.
     * The tokenizer uses the default delimiter set, which is " \t\n\r\f":
     * the space character, the tab character, the newline character,
     * the carriage-return character, and the form-feed character.
     * Delimiter characters themselves will not be treated as tokens.
     * @param str
     */
    public Tokenizer(String str){
        inputString = str;
        nextToken();
    }
    public Tokenizer(String str, String delim){
        inputString = str;
        currentChar = str.charAt(currentPosition);
    }
    public Tokenizer(String str, String delim, boolean returnDelim){
        inputString = str;
        currentChar = str.charAt(currentPosition);
    }

    public Object getCurrentToken(){
        return currentToken;
    }
    public boolean hasMoreTokens(){
        //return currentPosition < inputString.length();
        return currentToken != null;
    }
    public void nextToken(){
        consumewhite();
        if (currentPosition == inputString.length()){
            currentToken = null;
        } else if (Operations.contains(String.valueOf(inputString.charAt(currentPosition)))){
            currentToken = ""+inputString.charAt(currentPosition);
            currentPosition++;
        }
        else if (Character.isDigit(inputString.charAt(currentPosition)))
        {
            int startPosition = currentPosition;
            while(currentPosition < inputString.length() &&
                    Character.isDigit(inputString.charAt(currentPosition))){
                currentPosition++;
            }
            if (currentPosition+1 < inputString.length()
                    &&
                    inputString.charAt(currentPosition) =='.'
                    && Character.isDigit(inputString.charAt(currentPosition+1))){
                currentPosition++;
                while (currentPosition < inputString.length() &&
                        Character.isDigit(inputString.charAt(currentPosition)))
                    currentPosition++;
                currentToken = Float.parseFloat(inputString.substring(startPosition, currentPosition));
            } else {
                currentToken = Float.parseFloat(inputString.substring(startPosition,currentPosition));
            }
        } else {
            int start = currentPosition;
            while (currentPosition < inputString.length() && !Operations.contains(String.valueOf(inputString.charAt(currentPosition)))
                    && !isin(inputString.charAt(currentPosition), whitespace))
                currentPosition++;
            currentToken = inputString.substring(start, currentPosition);
        }
    }

    private void consumewhite(){
        while (currentPosition < inputString.length() &&isin(inputString.charAt(currentPosition),whitespace))
            currentPosition++;
    }

    private boolean isin(char c, char charList[]){
        for (char w: charList){
            if (w == c)
                return true;
        }

        return false;
    }
    public void parse(Object o) throws ParseException {
        if ( currentToken == null ||currentToken.equals(o))
            throw new ParseException();
        nextToken();
    }

}
