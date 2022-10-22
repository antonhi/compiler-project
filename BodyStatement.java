public class BodyStatement extends Statement {

    private StatementList statements;
    private OptionalSemi optionalSemi;

    public BodyStatement (StatementList statements, OptionalSemi optionalSemi) {
        this.statements = statements;
        this.optionalSemi = optionalSemi;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "{\n" + statements.toString(t+1) + getTabs(t) + "}" +optionalSemi.toString(0) + "\n";
    }
    
}
