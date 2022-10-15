public class BinaryExpression extends Expression {

    private Expression expression1, expression2;
    private Binaryop binaryop;

    public BinaryExpression (Expression expression1, Expression expression2, Binaryop binaryop) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.binaryop = binaryop;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + expression1.toString(0) + " " + binaryop.toString(0) + " " + expression2.toString(0);
    }
    
}
