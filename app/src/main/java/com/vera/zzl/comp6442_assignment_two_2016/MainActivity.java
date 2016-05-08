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

/**
 * MainActivity
 */
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
        textInputView = (TextView) findViewById(R.id.textViewDisplay);
        textOutputView = (TextView) findViewById(R.id.textOutputView);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/digital-7.ttf");
        textInputView.setTypeface(type);
        textOutputView.setTypeface(type);

    }

    /**
     * @param view
     */
    public void clearData(View view) {
        displayValue = "";
        textInputView.setText("");
        textOutputView.setText("");
    }

    /**
     * @param value
     */
    private void updateTextView(String value) {
        displayValue = displayValue + value;
        textInputView.setText(displayValue);
    }

    /**
     * @param view
     */
    public void buttonValueSeven(View view) {

        startNewExpression(view);
        updateTextView("7");
    }

    /**
     * @param view
     */
    private void startNewExpression(View view) {
        if (equalClicked) {
            equalClicked = false;
            clearData(view);
        }
    }

    /**
     * @param view
     */
    public void buttonValueEight(View view) {
        startNewExpression(view);
        updateTextView("8");
    }

    /**
     * @param view
     */
    public void buttonValueNine(View view) {
        startNewExpression(view);
        updateTextView("9");
    }

    /**
     * @param view
     */
    public void buttonValueFour(View view) {
        startNewExpression(view);
        updateTextView("4");
    }

    /**
     * @param view
     */
    public void buttonValueFive(View view) {
        startNewExpression(view);
        updateTextView("5");
    }

    /**
     * @param view
     */
    public void buttonValueSix(View view) {
        startNewExpression(view);
        updateTextView("6");
    }

    /**
     * @param view
     */
    public void buttonValueOne(View view) {
        startNewExpression(view);
        updateTextView("1");
    }

    /**
     * @param view
     */
    public void buttonValueTwo(View view) {
        startNewExpression(view);
        updateTextView("2");
    }

    /**
     * @param view
     */
    public void buttonValueThree(View view) {
        startNewExpression(view);
        updateTextView("3");
    }

    /**
     * @param view
     */
    public void buttonValueZero(View view) {
        startNewExpression(view);
        updateTextView("0");
    }

    /**
     * @param view
     */
    public void buttonValueDot(View view) {
        startNewExpression(view);
        updateTextView(".");
    }

    /**
     * @param view
     */
    public void buttonOperatorInc(View view) {
        startNewExpression(view);
        updateTextView("+");
    }

    /**
     * @param view
     */
    public void buttonOperatorDec(View view) {
        startNewExpression(view);
        updateTextView("-");
    }

    /**
     * @param view
     */
    public void buttonOperatorMul(View view) {
        startNewExpression(view);
        updateTextView("*");
    }

    /**
     * @param view
     */
    public void buttonOperatorDiv(View view) {
        startNewExpression(view);
        updateTextView("/");
    }

    /**
     * @param view
     */
    public void buttonPlusOrMinus(View view) {
        int temp;
        if (plusOrMinusCounter % 2 == 0) {
            temp = Integer.parseInt(displayValue);
            if (temp < 0) {
                temp = temp * -1;
            }
            displayValue = "" + temp;
            textInputView.setText(displayValue);

        } else {
            temp = Integer.parseInt(displayValue) * -1;
            displayValue = "" + temp;
            textInputView.setText(displayValue);
        }
        plusOrMinusCounter++;
    }

    /**
     * @param view
     */
    public void buttonModulus(View view) {

        startNewExpression(view);
        updateTextView("%");
    }

    /**
     * @param view
     */
    public void buttonBIN(View view) {
    }

    /**
     * @param view
     */
    public void buttonHEX(View view) {
    }

    /**
     * @param view
     */
    public void buttonDEC(View view) {
    }

    /**
     * @param view
     */
    public void buttonSquare(View view) {
    }

    /**
     * @param view
     */
    public void buttonSquareRoot(View view) {
    }

    /**
     * @param view
     */
    public void buttonLogicGateXOR(View view) {
    }

    /**
     * @param view
     */
    public void buttonLOG(View view) {
    }

    /**
     * @param view
     */
    public void buttonTAN(View view) {
    }

    /**
     * @param view
     */
    public void buttonLogicGateNOT(View view) {
    }

    /**
     * @param view
     */
    public void buttonSIN(View view) {
    }

    /**
     * @param view
     */
    public void buttonLogicGateOR(View view) {
    }

    /**
     * @param view
     */
    public void buttonCOS(View view) {
    }

    /**
     * @param view
     */
    public void buttonLogicGateAND(View view) {
    }

    /**
     * @param view
     */
    public void buttonOpenBracket(View view) {
    }

    /**
     * @param view
     */
    public void buttonClosedBracket(View view) {
    }

    /**
     * Need further actions.
     *
     * @param view
     */
    public void buttonPi(View view) {
        textInputView.setText("π");
        textOutputView.setText("" + Math.PI);

        startNewExpression(view);
        textInputView.setText("" + Math.PI);
    }


    /**
     * Do the calculate, need some optimize
     *
     * @param view
     */
    public void Calculate(View view) {
        String inputExpression = textInputView.getText().toString();
        EquationtoPostfix PostfixExpression = new EquationtoPostfix(inputExpression);
        String result = PostfixExpression.toString();
        Tokenizer evaluate = new Tokenizer(result);
        try {
            Expressions finalExpressionTree = Expressions.parse(evaluate);
            textOutputView.setText(String.valueOf(finalExpressionTree.evaluate()));
            displayValue =  displayValue + String.valueOf(finalExpressionTree.evaluate());
        } catch (ParseException e) {

        } finally {
            equalClicked = true;
            //clearData(view);
        }
    }
}
