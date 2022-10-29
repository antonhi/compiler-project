public class Methoddecl extends Token {

    private Returntype returntype;
    private String id;
    private Argdecls argdecls;
    private FielddeclList fielddeclList;
    private StatementList statementList;
    private OptionalSemi optionalSemi;

    public Methoddecl (Returntype returntype, String id, Argdecls argdecls, FielddeclList fielddeclList, StatementList statementList, OptionalSemi optionalSemi) {
        this.returntype = returntype;
        this.id = id;
        this.argdecls = argdecls;
        this.fielddeclList = fielddeclList;
        this.statementList = statementList;
        this.optionalSemi = optionalSemi;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + returntype.toString(0) + " " + id + " (" + argdecls.toString(0) + ") {\n" + fielddeclList.toString(t+1) + "\n" + statementList.toString(t+1) + getTabs(t) + "}" + optionalSemi.toString(0)+"\n";
    }
    
}
