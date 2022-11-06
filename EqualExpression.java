public class EqualExpression extends Expression {

    private Expression expression;

    public EqualExpression (Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "= " + expression.toString(0);
    }
}
