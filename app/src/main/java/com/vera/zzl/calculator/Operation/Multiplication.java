package com.vera.zzl.calculator.Operation;

import com.vera.zzl.calculator.core.Expressions;

/**
 * Created by Zhaolian on 25/04/2016.
 */
public class Multiplication extends Expressions {
    private Expressions leftPara;
    private Expressions rightPara;

    public Multiplication(Expressions leftPara, Expressions rightPara){
        this.leftPara = leftPara;
        this.rightPara = rightPara;
    }
    @Override
    public String show(){
        return "( "+ leftPara.show()+" " + rightPara.show() +" *)";
    }

    @Override
    public Float evaluate(){
        return (float)leftPara.evaluate()*(float)rightPara.evaluate();
    }
}
