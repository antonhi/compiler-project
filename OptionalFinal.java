public class OptionalFinal extends Token {

    private final boolean visible;

    public OptionalFinal(boolean visible) {
        this.visible = visible;
    }

    public String toString(int t) {
        return visible ? "final" : "";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        return null;
    }
}
