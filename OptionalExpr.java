public class OptionalExpr extends Token {

    private final Expression expression;

    public OptionalExpr(Expression expression) {
        this.expression = expression;
    }

    public String toString(int t) {
        return expression == null ? "" : expression.toString(t);
    }
    
}
