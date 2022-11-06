public class IfStatement extends Statement {

    private Expression expression;
    private FielddeclList fielddecls;
    private StatementList statements;
    private IfEnd ifEnd;

    public IfStatement (Expression expression, FielddeclList fielddecls, StatementList statements, IfEnd ifEnd) {
        this.expression = expression;
        this.fielddecls = fielddecls;
        this.statements = statements;
        this.ifEnd = ifEnd;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "if (" + expression.toString(0) + ") {\n" + fielddecls.toString(t+1) + (fielddecls.isEmpty() ? "" : "\n") + statements.toString(t+1) + getTabs(t) + "} " + ifEnd.toString(t) + "\n";
    }
    
}
