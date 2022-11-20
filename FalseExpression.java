import java.util.ArrayList;

public class FalseExpression extends Expression {

    @Override
    public String toString(int t) {
        return getTabs(t) + "(false)";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        return new TypeData("bool", false, false, new ArrayList<>());
    }
    
}
