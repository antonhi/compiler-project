public class OptionalSemi extends Token {
    private final boolean visible;

    public OptionalSemi(boolean visible) {
        this.visible = visible;
    }

    public String toString(int t) {
        return visible ? ";" : "";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        return null;
    }
}