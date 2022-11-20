public class PositiveExpression extends Expression {

    private Expression expression;

    public PositiveExpression (Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(+" + expression.toString(0) + ")";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        TypeData type = expression.typeCheck();
        if (!(type.getType().equals("float") || type.getType().equals("int"))) {
            throw new CompilerException("Error: Cannot make non-numeric expression positive");
        }
        return type;
    }
    
}
