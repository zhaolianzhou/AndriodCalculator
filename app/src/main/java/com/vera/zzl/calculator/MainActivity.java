package com.vera.zzl.calculator;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.vera.zzl.calculator.Operation.*;
import com.vera.zzl.calculator.Operation.Log;
import com.vera.zzl.calculator.core.*;
//import com.vera.zzl.comp6442_assignment_two_2016.core.Expressions;
//import com.vera.zzl.comp6442_assignment_two_2016.core.Tokenizer;
import com.vera.zzl.calculator.exceptions.ParseException;

import java.util.List;

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

    public void buttonHistory(View view){
        //Start a new intent and pass history values to next activity
        //display all the data on a list
        // add onclick function to list items
        // display it on calculator view
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivityForResult(intent, Constants.HISTORY_REQUEST_CODE);
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
        SetResult(view, ResultShow);
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
    public void buttonLogicGateAND(View view){
        startNewExpression(view);
        updateTextView("A");
    }
    public void buttonLogicGateOR(View view){
        startNewExpression(view);
        updateTextView("O");
    }
    public void buttonLogicGateNOT(View view){
        Expressions result = StringToFinalExpression(view);
        Expressions not = new Not(result);
        String ResultShow = String.valueOf(not.evaluate());
        SetResult(view, ResultShow);
    }
    public void buttonLogicGateXOR(View view){
        startNewExpression(view);
        updateTextView("X");
    }

    /**************************************************
     ******* Log function *****************************
     **************************************************/
    public void buttonLOG(View view){
        Expressions result = StringToFinalExpression(view);
        Expressions log = new Log(result);
        String ResultShow = String.valueOf(log.evaluate());
        SetResult(view, ResultShow);
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
    public void buttonHEX(View view){
        Expressions result = StringToFinalExpression(view);
        int resultRound = Math.round((float) result.evaluate());
        Expressions hex = new Hex(resultRound);
        String ResultShow = hex.evaluate().toString();
        SetResult(view,ResultShow);
    }
    public void buttonOCT(View view){
        Expressions result = StringToFinalExpression(view);
        int resultRound = Math.round((float) result.evaluate());
        Expressions oct = new Oct(resultRound);
        String ResultShow = oct.evaluate().toString();
        SetResult(view,ResultShow);
    }
    public void buttonBIN(View view){
        Expressions result = StringToFinalExpression(view);
        int resultRound = Math.round((float) result.evaluate());
        Expressions bin = new Bin(resultRound);
        String ResultShow = bin.evaluate().toString();
        SetResult(view,ResultShow);
    }

    /**
     * Do the calculate, need some optimize
     * @param view
     */
    public void Calculate(View view){
        Expressions result = StringToFinalExpression(view);
        String ResultShow = String.valueOf(result.evaluate());
        SetResult(view, ResultShow);
        String historyExpressionString = ""+ textInputView.getText().toString()+ "= "+
                ResultShow;
        InsertExpression(historyExpressionString);

    }

    private void InsertExpression(String historyExpressionString) {
        ContentValues values = new ContentValues();
        values.put(Constants.EXPRESSION_TEXT, historyExpressionString);
        Uri expressionURI =  getContentResolver().insert(Constants.CONTENT_URI, values);
        android.util.Log.d("MainActivity", expressionURI.getLastPathSegment());
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

    /**
     * Dispatch incoming result to the correct fragment.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        displayValue = "";
        if (data != null && requestCode == Constants.HISTORY_REQUEST_CODE){
            String value = data.getExtras().getString("SELECTED_EXPRESSION");
            String[] x = value.split("=");
            textInputView.setText(x[0]);
        }
    }
}
