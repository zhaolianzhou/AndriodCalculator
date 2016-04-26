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
    public float evaluate(){
        return leftPara.evaluate()*rightPara.evaluate();
    }

}
