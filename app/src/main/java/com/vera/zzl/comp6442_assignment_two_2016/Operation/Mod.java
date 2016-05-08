package com.vera.zzl.comp6442_assignment_two_2016.Operation;

import com.vera.zzl.comp6442_assignment_two_2016.core.Expressions;

/**
 * Created by Zhaolian on 30/04/2016.
 */
public class Mod extends Expressions {
    private Expressions leftPara;
    private Expressions rightPara;

    public Mod(Expressions leftPara, Expressions rightPara) {
        this.leftPara = leftPara;
        this.rightPara = rightPara;
    }

    @Override
    public String show() {
        return "( " + leftPara.show() + " " + rightPara.show() + " %)";
    }

    @Override
    public Float evaluate(){
        try {
            float rPara = (float)rightPara.evaluate();
            float lPara = (float)leftPara.evaluate();
            if (lPara!= Math.round(lPara)||rPara!= Math.round(rPara)){
                throw new ArithmeticException("Parameter is not a integer.");
            }

            return (float)leftPara.evaluate()%(float)rightPara.evaluate();
        }catch (ArithmeticException e){
            System.out.println("Warning! Attempted to mod by an non-integer!");
        }
        return 0f;
    }
}
