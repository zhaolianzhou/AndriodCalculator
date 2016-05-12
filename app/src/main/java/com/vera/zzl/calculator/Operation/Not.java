package com.vera.zzl.calculator.Operation;

import com.vera.zzl.calculator.core.Expressions;

/**
 * <h1>Add Two Numbers!</h1>
 * The AddNum program implements an application that
 * simply adds two given integer numbers and Prints
 * the output on the screen.
 * <p>ToDo: add propar class comments
 * <b>Note:</b> Giving proper comments in your program makes it more
 * user friendly and it is assumed as a high quality code.
 *
 * @author Zhaolian
 * @version 1.0
 * @since 8/05/2016
 **/
public class Not extends Expressions {
    private Expressions lPara;


    public Not(Expressions lPara){
        this.lPara = lPara;
    }

    @Override
    public String show(){
        return "( "+lPara.show() + " AND )";
    }

    @Override
    public Float evaluate(){
        float lpara = (float)lPara.evaluate();
        if (IsPositive(lpara) == 1)
            return -1f;
        else
            return 1f;
    }
}
