public class Type extends Token {

    private String type;

    public Type (String type) {
        this.type = type;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + type;
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        return null;
    }

    public String getType() { return type; }

    public boolean isArray() { return type.contains("[]"); }
    
}
