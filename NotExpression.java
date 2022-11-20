public class NotExpression extends Expression {

    private Expression expression;

    public NotExpression (Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(~" + expression.toString(0) + ")";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        if (!expression.typeCheck().getType().equals("bool")) {
            throw new CompilerException("Error: Cannot negate non-bool expression");
        }
        return expression.typeCheck();
    }
    
}
