import java.util.ArrayList;

public class Argdecl extends Token {

    private Type type;
    private String id;
    private boolean brackets;

    public Argdecl (Type type, String id, boolean brackets) {
        this.type = type;
        this.id = id;
        this.brackets = brackets;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + type.toString(0) + " " + id + (brackets ? "[]" : "");
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        symbolTable.addElement(id, type.getType(), false, brackets, new ArrayList<>());
        return null;
    }

    public String getName() { return id; }

    public TypeData getType() { return new TypeData(type.getType(), false, brackets, new ArrayList<>());}
    
}
