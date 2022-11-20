import java.util.ArrayList;

public class IntegerExpression extends Expression {

    private int number;

    public IntegerExpression (int number) {
        this.number = number;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(" + number + ")";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        return new TypeData("int", false, false, new ArrayList<>());
    }
    
}
