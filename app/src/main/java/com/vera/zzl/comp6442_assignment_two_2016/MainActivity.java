package com.vera.zzl.comp6442_assignment_two_2016;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.vera.zzl.comp6442_assignment_two_2016.Operation.*;
import com.vera.zzl.comp6442_assignment_two_2016.core.*;
//import com.vera.zzl.comp6442_assignment_two_2016.core.Expressions;
//import com.vera.zzl.comp6442_assignment_two_2016.core.Tokenizer;
import com.vera.zzl.comp6442_assignment_two_2016.exceptions.ParseException;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    int plusOrMinusCounter = 0;
    TextView textInputView;
    TextView textOutputView;
    String displayValue = "";

    boolean equalClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputView =(TextView) findViewById(R.id.textViewDisplay);
        textOutputView = (TextView) findViewById(R.id.textOutputView);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/digital-7.ttf");
        textInputView.setTypeface(type);
        textOutputView.setTypeface(type);

    }

    public  void clearData(View view){
        displayValue = "";
        textInputView.setText("");
        textOutputView.setText("");
    }

    private void updateTextView(String value){
        displayValue = displayValue + value ;
        textInputView.setText(displayValue);
    }
    public void buttonValueSeven(View view){

        startNewExpression(view);
        updateTextView("7");
    }

    private void startNewExpression(View view) {
        if (equalClicked) {
            equalClicked =false;
            clearData(view);
        }
    }

    public void buttonValueEight(View view){
        startNewExpression(view);
        updateTextView("8");
    }
    public void buttonValueNine(View view){
        startNewExpression(view);
        updateTextView("9");
    }
    public void buttonValueFour(View view){
        startNewExpression(view);
        updateTextView("4");
    }
    public void buttonValueFive(View view){
        startNewExpression(view);
        updateTextView("5");
    }
    public void buttonValueSix(View view){
        startNewExpression(view);
        updateTextView("6");
    }
    public void buttonValueOne(View view){
        startNewExpression(view);
        updateTextView("1");
    }
    public void buttonValueTwo(View view){
        startNewExpression(view);
        updateTextView("2");
    }
    public void buttonValueThree(View view){
        startNewExpression(view);
        updateTextView("3");
    }
    public void buttonValueZero(View view){
        startNewExpression(view);
        updateTextView("0");
    }
    public void buttonValueDot(View view){
        startNewExpression(view);
        updateTextView(".");
    }

    public void buttonOperatorInc(View view){
        startNewExpression(view);
        updateTextView("+");}
    public void buttonOperatorDec(View view){
        startNewExpression(view);
        updateTextView("-");}
    public void buttonOperatorMul(View view){
        startNewExpression(view);
        updateTextView("*");}
    public void buttonOperatorDiv(View view){
        startNewExpression(view);
        updateTextView("/");}
    public void buttonPlusOrMinus(View view){
        int temp;
        if ( plusOrMinusCounter % 2 == 0 ){
            temp = Integer.parseInt(displayValue);
            if ( temp < 0 ){
                temp = temp * -1;
            }
            displayValue = ""+ temp;
            textInputView.setText(displayValue);

        }else {
            temp = Integer.parseInt(displayValue) * -1;
            displayValue = ""+ temp;
            textInputView.setText(displayValue);
        }
        plusOrMinusCounter++;
    }
    public void buttonModulus (View view){

        startNewExpression(view);
        updateTextView("%");
    }
    public void buttonSquare(View view){
        startNewExpression(view);
        updateTextView("^");
    }
    public void buttonLeftBracket(View view){
        startNewExpression(view);
        updateTextView("(");
    }
    public void buttonRightBracket(View view){
        startNewExpression(view);
        updateTextView(")");
    }
    /**
     * Need further actions.
     * @param view
     */
    public void buttonPi (View view){
        textInputView.setText("π");
        textOutputView.setText("" + Math.PI);

        startNewExpression(view);
        textInputView.setText("" + Math.PI);
    }


    /**************************************************
     ***** Trigonometric function button***************
     **************************************************/
    public void buttonSIN(View view){
        Expressions result = StringToFinalExpression(view);
        Expressions sin = new Sin(result);
        String ResultShow = String.valueOf(sin.evaluate());
        SetResult(view,ResultShow);
    }
    public void buttonCOS(View view){
        Expressions result = StringToFinalExpression(view);
        Expressions cos = new Cos(result);
        String ResultShow = String.valueOf(cos.evaluate());
        SetResult(view,ResultShow);
    }
    public void buttonTAN(View view){
        Expressions result = StringToFinalExpression(view);
        Expressions tan = new Tan(result);
        String ResultShow = String.valueOf(tan.evaluate());
        SetResult(view,ResultShow);
    }

    /************************************************
     *********Logic Gate button  ********************
     ************************************************/
    public void buttonLogicGateAND(View view){}
    public void buttonLogicGateOR(View view){}
    public void buttonLogicGateNOT(View view){}
    public void buttonLogicGateXOR(View view){}

    /**************************************************
     ******* Log function *****************************
     **************************************************/
    public void buttonLOG(View view){
        Expressions result = StringToFinalExpression(view);
        Expressions log = new Log(result);
        String ResultShow = String.valueOf(log.evaluate());
        SetResult(view,ResultShow);
    }

    /**************************************************
     ******* Square Root function *********************
     **************************************************/
    public void buttonSquareRoot(View view){
        Expressions result = StringToFinalExpression(view);
        Expressions sqrt = new Sqrt(result);
        String ResultShow = String.valueOf(sqrt.evaluate());
        SetResult(view,ResultShow);
    }
    /**************************************************
     ******* HEX, DEC, BIN function *********************
     **************************************************/
    public void buttonHEX(View view){}
    public void buttonDEC(View view){}
    public void buttonBIN(View view){}



    /**
     * Do the calculate, need some optimize
     * @param view
     */
    public void Calculate(View view){
        Expressions result = StringToFinalExpression(view);
        String ResultShow = String.valueOf(result.evaluate());
        SetResult(view, ResultShow);
    }

    private Expressions StringToFinalExpression(View view){
        String inputExpression = textInputView.getText().toString();
        EquationtoPostfix PostfixExpression = new EquationtoPostfix(inputExpression);
        Tokenizer infixToken = new Tokenizer(inputExpression);
        List<Object> result = PostfixExpression.Convert(infixToken);
        Expressions finalExpressionTree = null;
        try {
            finalExpressionTree = Expressions.parse(result);
        }catch (ParseException e){
        }
        return finalExpressionTree;
    }

    private void SetResult(View view, String result){
        textOutputView.setText(result);
        equalClicked = true;
    }
}
