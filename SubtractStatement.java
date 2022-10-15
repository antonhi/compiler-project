public class SubtractStatement extends Statement {

    private Name name;

    public SubtractStatement (Name name) {
        this.name = name;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + name.toString(0) + "--;\n";
    }
    
}
