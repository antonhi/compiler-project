import java.util.ArrayList;
import java.util.List;

public class ReadList extends Token {

    private List<Name> names;

    public ReadList() {
        names = new ArrayList<>();
    }

    public ReadList prepend(Name name) {
        names.add(0, name);
        return this;
    }

    @Override
    public String toString(int t) {
        String result = "";
        int index = 0;
        for (Name n : names) {
            result += n.toString(0) + (++index == names.size() ? "" : ", ");
        }
        return result;
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        for (Name name : names) {
            TypeData type = name.typeCheck();
            if (type.isArray() || type.isFunction() || type.isFinal()) {
                throw new CompilerException("Error: Tried reading array, function, or final type");
            }
        }
        return null;
    }
    
}
