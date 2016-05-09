package com.vera.zzl.comp6442_assignment_two_2016.Operation;

import com.vera.zzl.comp6442_assignment_two_2016.core.Expressions;

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
public class Pow extends Expressions {
    private Expressions lPara;
    private Expressions rPara;

    public Pow(Expressions lPara, Expressions rPara){
        this.lPara = lPara;
        this.rPara = rPara;
    }

    @Override
    public String show(){
        return "( "+lPara.show() +" " + rPara.show() + " ^ )";
    }

    @Override
    public Float evaluate(){
        float lpara = (float)lPara.evaluate();
        float rpara = (float)rPara.evaluate();
        return (float) Math.pow(lpara,rpara);
    }
}