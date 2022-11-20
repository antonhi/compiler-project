public class Binaryop extends Token {
    private String value;
    public Binaryop(String s) {
        value = s;
    }
    @Override
    public String toString(int t) {
        return getTabs(t) + value;
    }
    public String getValue() { return value; }
    @Override
    public TypeData typeCheck() throws CompilerException {
        return null;
    }
}