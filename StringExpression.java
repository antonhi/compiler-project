import java.util.ArrayList;

public class StringExpression extends Expression {

    private String string;

    public StringExpression (String string) {
        this.string = string;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(" + string + ")";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        return new TypeData("string", false, false, new ArrayList<>());
    }
    
}
