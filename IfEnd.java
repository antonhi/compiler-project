public class IfEnd extends Token {

    private FielddeclList fielddecls;
    private StatementList statementList;

    public IfEnd () {
        statementList = null;
        fielddecls = null;
    }

    public IfEnd (FielddeclList fielddecls, StatementList statementList) {
        this.statementList = statementList;
        this.fielddecls = fielddecls;
    }

    @Override
    public String toString(int t) {
        String result = "";
        if (fielddecls != null || statementList != null) {
            result += "else {\n";
        }
        if (fielddecls != null) {
            result += fielddecls.toString(t+1);
        }
        if (statementList != null) {
            if (fielddecls != null && !fielddecls.isEmpty()) {
                result += "\n";
            }
            result += statementList.toString(t+1);
        }
        if (fielddecls != null || statementList != null) {
            result += getTabs(t) + "}";
        }
        return result;
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        symbolTable.startScope();
        if (fielddecls != null) {
            fielddecls.typeCheck();
        }
        if (statementList != null) {
            statementList.typeCheck();
        }
        symbolTable.endScope();
        return null;
    }
    
}
