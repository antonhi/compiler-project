public class BodyStatement extends Statement {

    private FielddeclList fielddecls;
    private StatementList statements;
    private OptionalSemi optionalSemi;

    public BodyStatement (FielddeclList fielddecls, StatementList statements, OptionalSemi optionalSemi) {
        this.fielddecls = fielddecls;
        this.statements = statements;
        this.optionalSemi = optionalSemi;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "{\n" + fielddecls.toString(t+1) + "\n" + statements.toString(t+1) + getTabs(t) + "}" +optionalSemi.toString(0) + "\n";
    }
    
}
