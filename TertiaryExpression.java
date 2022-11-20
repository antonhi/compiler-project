public class TertiaryExpression extends Expression {

    private Expression expression1, expression2, expression3;

    public TertiaryExpression (Expression expression1, Expression expression2, Expression expression3) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.expression3 = expression3;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "((" + expression1.toString(0) + " ? " + expression2.toString(0) + " : " + expression3.toString(0) + "))";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        if (!expression1.typeCheck().getType().equals("bool")) {
            throw new CompilerException("Error: Expression 1 is not of type bool");
        }
        if (!expression2.typeCheck().getType().equals(expression3.typeCheck().getType())) {
            throw new CompilerException("Error: Expression 2 is not of the same type as Expression 3");
        }
        return expression2.typeCheck();
    }
    
}
