public class PositiveExpression extends Expression {

    private Expression expression;

    public PositiveExpression (Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(+" + expression.toString(0) + ")";
    }
    
}
