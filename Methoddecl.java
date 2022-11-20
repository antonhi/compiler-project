public class Methoddecl extends Token {

    private Type type;
    private String id;
    private Argdecls argdecls;
    private FielddeclList fielddeclList;
    private StatementList statementList;
    private OptionalSemi optionalSemi;

    public Methoddecl (Type type, String id, Argdecls argdecls, FielddeclList fielddeclList, StatementList statementList, OptionalSemi optionalSemi) {
        this.type = type;
        this.id = id;
        this.argdecls = argdecls;
        this.fielddeclList = fielddeclList;
        this.statementList = statementList;
        this.optionalSemi = optionalSemi;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + (type == null ? "" : type.toString(0)) + " " + id + "(" + argdecls.toString(0) + ") {\n" + fielddeclList.toString(t+1) + (fielddeclList.isEmpty() ? "" : "\n") + statementList.toString(t+1) + getTabs(t) + "}" + optionalSemi.toString(0)+"\n";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        symbolTable.addElement(id, type.getType(), false, false, argdecls.getArgTypes());
        argdecls.typeCheck();
        symbolTable.startScope();
        fielddeclList.typeCheck();
        statementList.typeCheck();
        symbolTable.endScope();
        return null;
    }
    
}
