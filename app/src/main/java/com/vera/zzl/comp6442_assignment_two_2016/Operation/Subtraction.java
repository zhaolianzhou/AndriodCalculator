package com.vera.zzl.comp6442_assignment_two_2016.Operation;

import com.vera.zzl.comp6442_assignment_two_2016.core.Expressions;

/**
 * Created by Zhaolian on 25/04/2016.
 */
public class Subtraction extends Expressions {
    private Expressions leftPara;
    private Expressions rightPara;

    public Subtraction(Expressions leftPara, Expressions rightPara){
        this.leftPara = leftPara;
        this.rightPara = rightPara;
    }
    @Override
    public String show(){
        return "( "+ leftPara.show()+" " + rightPara.show() +" - )";
    }

    @Override
    public float evaluate(){
        return leftPara.evaluate() - rightPara.evaluate();
    }

}
