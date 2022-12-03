import java.util.ArrayList;
import java.util.List;

public class StatementList extends Token {

    private List<Statement> statements;

    public StatementList() {
        statements = new ArrayList<>();
    }

    public StatementList prepend(Statement s) {
        statements.add(0, s);
        return this;
    }

    public StatementList append(Statement s) {
        statements.add(s);
        return this;
    }

    @Override
    public String toString(int t) {
        String result = "";
        for (Statement statement : statements) {
            result += statement.toString(t);
        }
        return result;
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        for (Statement s : statements) {
            s.typeCheck();
        }
        return null;
    }

    public TypeData getReturnType() throws CompilerException {
        if (!statements.isEmpty()) {
            if (statements.get(statements.size()-1) instanceof ReturnExpressionStatement) {
                return ((ReturnExpressionStatement) statements.get(statements.size()-1)).getReturnType();
            } else if (statements.get(statements.size()-1) instanceof ReturnStatement) {
                return ((ReturnStatement) statements.get(statements.size()-1)).getReturnType();
            }
        }
        return null;
    }
    
}