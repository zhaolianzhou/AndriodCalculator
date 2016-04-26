import java.beans.Expression;
import java.util.Stack;
import java.util.StringTokenizer;

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
    public abstract float evaluate();

    private static Stack<Expressions> expressionsStack = new Stack<>();
    static public Stack<Expressions> parse(Tokenizer myTokenizer) throws ParseException{

        /*  Add code that will parse the string
            creating the expression for that string */
        //Tokenizer myTokenizer = new Tokenizer(str);
        while (myTokenizer.hasMoreTokens()) {
            Object currentToken = myTokenizer.getCurrentToken();
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
                myTokenizer.nextToken();
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Subtraction(lPara, rPara);
            } else if (currentToken.equals("*")) {
                myTokenizer.nextToken();
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Multiplication(lPara, rPara);
            } else if (currentToken.equals("/")) {
                myTokenizer.nextToken();
                Expressions rPara = expressionsStack.pop();
                Expressions lPara = expressionsStack.pop();
                Expressions result = new Division(lPara, rPara);
            } else if (currentToken.equals("(")) {
                myTokenizer.parse("(");
            } else if (currentToken.equals(")")) {
                myTokenizer.parse(")");
            } else {
                throw new ParseException();
            }
        }
        return expressionsStack;
    }

        /*  This is a place holder in order to get show
            and evaluate working first */
}
