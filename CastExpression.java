public class CastExpression extends Expression {

    private Type type;
    private Expression expression;

    public CastExpression (Type type, Expression expression) {
        this.type = type;
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(" + type.toString(0) + ") " + expression.toString(0);
    }
    
}
