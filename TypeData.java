import java.util.List;

public class TypeData {
    private boolean isFinal, isArray;
    private List<TypeData> args;
    private String type;

    public TypeData (String type, boolean isFinal, boolean isArray, List<TypeData> args) {
        this.isArray = isArray;
        this.isFinal = isFinal;
        this.args = args;
        this.type = type;
    }

    public String toString () {
        return type + "(final: " + isFinal + " | array: " + isArray + " | args: " + (args.isEmpty() ? "none)" : getArgs() + ")");
    }

    public String getType() { return type; }
    public boolean isFinal() { return isFinal; }
    public boolean isArray() { return isArray; }
    public boolean isFunction() { return !args.isEmpty(); }
    public int getArgsAmount() { return args.size(); }
    public List<TypeData> getArgsList() { return args; }

    public boolean same(TypeData typeData) {
        boolean res = typeData.getType().equals(type);
        if (!res) {
            res = isCoercible(typeData);
        }
        if (!res) return false;
        res = typeData.isFunction() == isFunction() && typeData.isArray == isArray;
        if (!res) return false;
        res = getArgsAmount() == typeData.getArgsAmount();
        if (!res) return false;
        int index = 0;
        for (TypeData t : typeData.getArgsList()) {
            if (!t.getType().equals(args.get(index).getType())) return false;
        }
        return true;
    }

    private boolean isCoercible(TypeData otherType) {
        if (isArray || isFunction() || otherType.isArray || otherType.isFunction()) {
            return false;
        }
        if (type.equals("float")) {
            if (otherType.getType().equals("int")) return true;
        }
        if (type.equals("bool")) {
            if (otherType.getType().equals("int")) return true;
        }
        if (type.equals("int")) {
           if (otherType.getType().equals("char")) return true;
        }
        return false;
    }

    private String getArgs() {
        String output = "";
        for (TypeData s : args) {
            output += s.toString();
        }
        return output;
    }
}
