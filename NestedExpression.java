public class NestedExpression extends Expression {

    private Expression expression;

    public NestedExpression (Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(" + expression.toString(0) + ")";
    }
    
}
