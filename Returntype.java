public class Returntype extends Token {

    private final Type type;

    public Returntype (Type type) {
        this.type = type;
    }

    @Override
    public String toString(int t) {
        return type == null ? "void" : type.toString(t); 
    }
    
}
