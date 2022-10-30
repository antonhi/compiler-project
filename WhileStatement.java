public class WhileStatement extends Statement {

    private Expression expression;
    private FielddeclList fielddecls;
    private StatementList statements;

    public WhileStatement (Expression expression, FielddeclList fielddecls, StatementList statements) {
        this.expression = expression;
        this.fielddecls = fielddecls;
        this.statements = statements;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "while (" + expression.toString(0) + ") {\n" + fielddecls.toString(t+1) + "\n" + statements.toString(t+1) + getTabs(t) + "}\n";
    }
    
}
