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
    
}
