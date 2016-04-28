package com.vera.zzl.comp6442_assignment_two_2016;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView ;
    String displayValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.textViewDisplay);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/digital-7.ttf");
        textView.setTypeface(type);
    }

    public  void clearData(View view){
        displayValue = "";
        textView.setText("");
    }

    private void updateTextView(String value){
        displayValue = displayValue + value ;
        textView.setText(displayValue);
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
}
