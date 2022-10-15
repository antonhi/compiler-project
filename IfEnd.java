public class IfEnd extends Token {

    private StatementList statementList;

    public IfEnd (StatementList statementList) {
        this.statementList = statementList;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "else {\n" + statementList.toString(t+1) + getTabs(t) + "}";
    }
    
}
