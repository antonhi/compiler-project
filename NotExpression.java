public class NotExpression extends Expression {

    private Expression expression;

    public NotExpression (Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "~" + expression.toString(0);
    }
    
}
