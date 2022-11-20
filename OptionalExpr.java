import java.util.ArrayList;

public class OptionalExpr extends Token {

    private final Expression expression;

    public OptionalExpr(Expression expression) {
        this.expression = expression;
    }

    public boolean populated () { return expression != null; }

    public String toString(int t) {
        return expression == null ? "" : expression.toString(t);
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        return expression == null ? new TypeData("string", false, false, new ArrayList<>()) : expression.typeCheck();
    }
    
}
