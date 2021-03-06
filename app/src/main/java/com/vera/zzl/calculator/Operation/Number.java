package com.vera.zzl.calculator.Operation;

import com.vera.zzl.calculator.core.Expressions;

/**
 * Created by Zhaolian on 25/04/2016.
 */
public class Number extends Expressions {
    private float value;

    public Number(float value){
        this.value = value;
    }

    public Number(String value){
        this.value = Float.valueOf(value);
    }

    public Number(Double value){
        this.value = value.floatValue();
    }

    @Override
    public String show(){
        return String.valueOf(value);
    }

    @Override
    public Float evaluate(){
        return value;
    }
}
