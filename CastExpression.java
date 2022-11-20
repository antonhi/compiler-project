import java.util.ArrayList;

public class CastExpression extends Expression {

    private Type type;
    private Expression expression;

    public CastExpression (Type type, Expression expression) {
        this.type = type;
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "((" + type.toString(0) + ") " + expression.toString(0) + ")";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        TypeData type = expression.typeCheck();
        if (type.isFinal() || type.isArray() || type.isFunction()) {
            throw new CompilerException("Error: Could not cast final, array, or function expression");
        }
        return new TypeData(type.getType(), false, false, new ArrayList<>());
    }

    
}
