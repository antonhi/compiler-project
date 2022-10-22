public class NegateExpression extends Expression {

    private Expression expression;

    public NegateExpression (Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(-" + expression.toString(0) + ")";
    }
    
}
