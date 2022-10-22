public class ParameterConstructorExpression extends Expression {

    private Args args;
    private String id;

    public ParameterConstructorExpression (Args args, String id) {
        this.args = args;
        this.id = id;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(" + id + "(" + args.toString(0) + "))";
    }
    
}
