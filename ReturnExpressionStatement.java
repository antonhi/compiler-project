public class ReturnExpressionStatement extends Statement {

    private Expression expression;

    public ReturnExpressionStatement (Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "return " + expression.toString(0) + ";\n";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        expression.typeCheck();
        return null;
    }

    public TypeData getReturnType() throws CompilerException {
         return expression.typeCheck();
    }
    
}
