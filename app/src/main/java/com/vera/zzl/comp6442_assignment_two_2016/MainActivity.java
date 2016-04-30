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

public class MainActivity extends AppCompatActivity {
    int plusOrMinusCounter = 0;
    TextView textInputView;
    TextView textOutputView;
    String displayValue = "";

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
        updateTextView("7");
    }
    public void buttonValueEight(View view){
        updateTextView("8");
    }
    public void buttonValueNine(View view){
        updateTextView("9");
    }
    public void buttonValueFour(View view){
        updateTextView("4");
    }
    public void buttonValueFive(View view){
        updateTextView("5");
    }
    public void buttonValueSix(View view){
        updateTextView("6");
    }
    public void buttonValueOne(View view){
        updateTextView("1");
    }
    public void buttonValueTwo(View view){
        updateTextView("2");
    }
    public void buttonValueThree(View view){
        updateTextView("3");
    }
    public void buttonValueZero(View view){
        updateTextView("0");
    }
    public void buttonValueDot(View view){
        updateTextView(".");
    }

    public void buttonOperatorInc(View view){updateTextView("+");}
    public void buttonOperatorDec(View view){updateTextView("-");}
    public void buttonOperatorMul(View view){updateTextView("*");}
    public void buttonOperatorDiv(View view){updateTextView("/");}
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
        updateTextView("%");
    }

    /**
     * Need further actions.
     * @param view
     */
    public void buttonPi (View view){
        textInputView.setText("π");
        textOutputView.setText("" + Math.PI);
    }


    /**
     * Do the calculate, need some optimize
     * @param view
     */
    public void Calculate(View view){
        String inputExpression = textInputView.getText().toString();
        EquationtoPostfix PostfixExpression = new EquationtoPostfix(inputExpression);
        String result = PostfixExpression.toString();
        Tokenizer evaluate = new Tokenizer(result);
        try {
            Expressions finalExpressionTree = Expressions.parse(evaluate);
            textOutputView.setText(String.valueOf(finalExpressionTree.evaluate()));
        }catch (ParseException e){

        }
    }
}
