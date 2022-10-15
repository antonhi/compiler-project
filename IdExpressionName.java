public class IdExpressionName extends Name {

    private Expression expression;

    public IdExpressionName(String id, Expression expression) {
        super(id);
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + id + " [" + expression.toString(0) + "]";
    }
    
}
