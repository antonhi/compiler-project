import java.util.List;

public class Argdecls extends Token {

    private ArgdeclList argdeclList;

    public Argdecls (ArgdeclList argdeclList) {
        this.argdeclList = argdeclList;
    }

    @Override
    public String toString(int t) {
        return argdeclList == null ? "" : argdeclList.toString(t);
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        argdeclList.typeCheck();
        return null;
    }

    public List<TypeData> getArgTypes() {
        return argdeclList.getArgTypes();
    }
    
}
