public class NameExpression extends Expression {

    private Name name;

    public NameExpression (Name name) {
        this.name = name;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(" + name.toString(0) + ")";
    }
    
}
