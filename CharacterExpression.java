import java.util.ArrayList;

public class CharacterExpression extends Expression {

    private String character;

    public CharacterExpression (String character) {
        this.character = character;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(" + character + ")";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        return new TypeData("char", false, false, new ArrayList<>());
    }
    
}
