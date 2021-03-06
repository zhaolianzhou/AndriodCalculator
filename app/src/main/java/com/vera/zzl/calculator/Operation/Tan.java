package com.vera.zzl.calculator.Operation;

import com.vera.zzl.calculator.core.Expressions;

/**
 * <h1>Add Two Numbers!</h1>
 * The AddNum program implements an application that
 * simply adds two given integer numbers and Prints
 * the output on the screen.
 * <p>ToDo: add proper class comments
 * <b>Note:</b> Giving proper comments in your program makes it more
 * user friendly and it is assumed as a high quality code.
 *
 * @author Zhaolian
 * @version 1.0
 * @since 8/05/2016
 **/
public class Tan extends Expressions {
    private Expressions para;

    public Tan(Expressions para){
        this.para = para;
    }

    @Override
    public String show(){
        return para.show() + " tan";
    }

    @Override
    public Float evaluate(){
        float rPara = (float)para.evaluate();
        return (float) Math.tan(rPara);
    }
}
