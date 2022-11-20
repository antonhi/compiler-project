import java.util.ArrayList;

public class TrueExpression extends Expression {

    @Override
    public String toString(int t) {
        return getTabs(t) + "(true)";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        return new TypeData("bool", false, false, new ArrayList<>());
    }
    
}
