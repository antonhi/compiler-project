public class NegateExpression extends Expression {

    private Expression expression;

    public NegateExpression (Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(-" + expression.toString(0) + ")";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        TypeData type = expression.typeCheck();
        if (type.isArray() || type.isFunction() || type.isFinal() || !(type.getType().equals("int") || type.getType().equals("float"))) {
            throw new CompilerException("Error: Cannot negate array, function, a final expression, or types that are not 'int' or 'float'");
        }
        return type;
    }
    
}
