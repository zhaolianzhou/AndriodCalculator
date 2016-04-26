
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;
import java.util.Stack;

/**
 * Created by Zhaolian on 26/04/2016.
 */
public class EquationtoPostfix {
    //Store the expression.
    private static Stack<Expressions> expressionsStack = new Stack<>();
    private String infixExpression;
    private String postfixExpression;
    private Tokenizer infixTokenizer;
    private static int currentPosition = 0;
    //private static char currentChar;

    public EquationtoPostfix(String str){
        infixExpression = str;
        infixTokenizer = new Tokenizer(str);
    }
    public List<String> Convert(Tokenizer myTokenizer){
        Stack<String> operatorStack = new Stack<>();
        List<String> output = new ArrayList<>();
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
                output.add(currentToken.toString());
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
                output.add(currentToken.toString());
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
        for (String c : this.Convert(this.infixTokenizer)){
            result +=c + " ";
        }
        return result;
    }
}
