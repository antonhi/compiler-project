public class IfStatement extends Statement {

    private Expression expression;
    private StatementList statements;
    private IfEnd ifEnd;

    public IfStatement (Expression expression, StatementList statements, IfEnd ifEnd) {
        this.expression = expression;
        this.statements = statements;
        this.ifEnd = ifEnd;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "if (" + expression.toString(0) + ") {\n" + statements.toString(t+1) + getTabs(t) + "} " + ifEnd.toString(0) + "\n";
    }
    
}
