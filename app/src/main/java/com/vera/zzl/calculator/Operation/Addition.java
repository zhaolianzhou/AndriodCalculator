package com.vera.zzl.calculator.Operation;

import com.vera.zzl.calculator.core.Expressions;

/**
 * Created by Zhaolian on 25/04/2016.
 */
public class Addition extends Expressions {
    private Expressions leftPara;
    private Expressions rightPara;

    public Addition(Expressions leftPara, Expressions rightPara){
        this.leftPara = leftPara;
        this.rightPara = rightPara;
    }
    @Override
    public String show(){
        return "( "+ leftPara.show()+" " + rightPara.show() +" +)";
    }

    @Override
    public Float evaluate(){
        return (float)leftPara.evaluate() + (float)rightPara.evaluate();
    }
}
