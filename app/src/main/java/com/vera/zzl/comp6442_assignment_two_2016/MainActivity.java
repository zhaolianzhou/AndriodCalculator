package com.vera.zzl.comp6442_assignment_two_2016;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.vera.zzl.comp6442_assignment_two_2016.core.EquationtoPostfix;
import com.vera.zzl.comp6442_assignment_two_2016.core.Expressions;
import com.vera.zzl.comp6442_assignment_two_2016.core.Tokenizer;
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


    /**
     * Do the calculate, need some optimize
     * @param view
     */
    public void Calculate(View view){
        String inputExpression = textInputView.getText().toString();
        EquationtoPostfix PostfixExpression = new EquationtoPostfix(inputExpression);
        Tokenizer infixToken = new Tokenizer(inputExpression);
        List<Object> result = PostfixExpression.Convert(infixToken);
        try {
            Expressions finalExpressionTree = Expressions.parse(result);
            textOutputView.setText(String.valueOf(finalExpressionTree.evaluate()));
        }catch (ParseException e){

        }

        finally {
            equalClicked =true;
            //clearData(view);
        }
    }
}
