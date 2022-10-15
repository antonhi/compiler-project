public class ConstructorStatement extends Statement {

    private String id;

    public ConstructorStatement (String id) {
        this.id = id;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + id + "();\n";
    }
    
}
