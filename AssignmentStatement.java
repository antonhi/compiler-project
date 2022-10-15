public class AssignmentStatement extends Statement {

    private Name name;
    private Expression expression;

    public AssignmentStatement (Name name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + name.toString(0) + " = " + expression.toString(0) + ";";
    }
    
}
