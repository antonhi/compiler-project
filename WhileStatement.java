public class WhileStatement extends Statement {

    private Expression expression;
    private StatementList statements;

    public WhileStatement (Expression expression, StatementList statements) {
        this.expression = expression;
        this.statements = statements;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "while (" + expression.toString(0) + ") {\n" + statements.toString(t+1) + getTabs(t) + "}\n";
    }
    
}
