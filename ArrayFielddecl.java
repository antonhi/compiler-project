public class ArrayFielddecl extends Fielddecl {

    private Type type;
    private String id;
    private int number;

    public ArrayFielddecl (Type type, String id, int number) {
        this.type = type;
        this.id = id;
        this.number = number;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + type.toString(0) + " " + id + " [" + number + "];\n";
    }
    
}
