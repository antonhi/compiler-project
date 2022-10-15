public class BodyStatement extends Statement {

    private StatementList statements;

    public BodyStatement (StatementList statements) {
        this.statements = statements;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "{\n" + statements.toString(t+1) + getTabs(t) + "}\n";
    }
    
}
