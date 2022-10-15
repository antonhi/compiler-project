public class ParameterConstructorStatement extends Statement {

    private String id;
    private Args args;

    public ParameterConstructorStatement (String id, Args args) {
        this.id = id;
        this.args = args;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + id + "(" + args.toString(0) + ");\n";
    }
    
}
