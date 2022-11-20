import java.util.ArrayList;
import java.util.List;

public class ArgdeclList extends Token {

    private List<Argdecl> argdecls;

    public ArgdeclList () {
        argdecls = new ArrayList<>();
    }

    public ArgdeclList prepend(Argdecl argdecl) {
        argdecls.add(0, argdecl);
        return this;
    }

    public List<TypeData> getArgTypes() {
        List<TypeData> types = new ArrayList<>();
        for (Argdecl decl : argdecls) {
            types.add(decl.getType());
        }
        return types;
    }

    @Override
    public String toString(int t) {
        String result = "";
        int index = 0;
        for (Argdecl n : argdecls) {
            result += n.toString(0) + (++index == argdecls.size() ? "" : ", ");
        }
        return result;
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        for (Argdecl decl : argdecls) {
            decl.typeCheck();
        }
        return null;
    }
    
}
