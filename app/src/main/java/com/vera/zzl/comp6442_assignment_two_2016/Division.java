/**
 * Created by Zhaolian on 25/04/2016.
 */
public class Division extends Expressions {
    private Expressions leftPara;
    private Expressions rightPara;

    public Division(Expressions leftPara, Expressions rightPara){
        this.leftPara = leftPara;
        this.rightPara = rightPara;
    }
    @Override
    public String show(){
        return "( "+ leftPara.show()+" " + rightPara.show() +" /)";
    }

    @Override
    public float evaluate(){
        try {
            float rPara = rightPara.evaluate();
            float expected = 0;
            if (Math.abs(rPara - expected) < 0.00001){
                throw new ArithmeticException("Divide by zero");
            }
            return leftPara.evaluate()/rightPara.evaluate();
        }catch (ArithmeticException e){
            System.out.println("Warning! Attempted to divide by zero!");
        }
        return 0;
    }

}
