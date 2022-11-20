import java.util.ArrayList;
import java.util.List;

public class FielddeclList extends Token {

    private List<Fielddecl> fielddeclList;

    public FielddeclList () {
        fielddeclList = new ArrayList<>();
    }

    public FielddeclList prepend(Fielddecl f) {
        fielddeclList.add(0, f);
        return this;
    }

    public boolean isEmpty() { return fielddeclList.isEmpty(); }

    @Override
    public String toString(int t) {
        String result = "";
        for (Fielddecl fielddecl : fielddeclList) {
            result += fielddecl.toString(t);
        }
        return result;
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        for (Fielddecl decl : fielddeclList) {
            decl.typeCheck();
        }
        return null;
    }
    
}
