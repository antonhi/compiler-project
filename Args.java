import java.util.ArrayList;
import java.util.List;

public class Args extends Token {

    private List<Expression> expressions;

    public Args() {
        expressions = new ArrayList<>();
    }

    public Args prepend(Expression expression) {
        expressions.add(0, expression);
        return this;
    }

    @Override
    public String toString(int t) {
        String result = "";
        int index = 0;
        for (Expression e : expressions) {
            result += e.toString(0) + (++index == expressions.size() ? "" : ", ");
        }
        return result;
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        for (Expression e : expressions) {
            e.typeCheck();
        }
        return null;
    }

    public List<TypeData> getTypes() throws CompilerException{
        List<TypeData> types = new ArrayList<>();
        for (Expression e : expressions) {
            types.add(e.typeCheck());
        }
        return types;
    }
    
}
