public class AssignmentStatement extends Statement {

    private Name name;
    private Expression expression;

    public AssignmentStatement (Name name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + name.toString(0) + " = " + expression.toString(0) + ";\n";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        TypeData lhs = name.typeCheck();
        TypeData rhs = expression.typeCheck();
        if (lhs == null || rhs == null) {
            throw new CompilerException("Error: " + name.id + " has not been defined and cannot be assigned");
        } else if (lhs.isFinal() || !lhs.same(rhs)) {
            throw new CompilerException("Error: " + lhs.getType() + " is not assignable to " + rhs.getType());
        }
        return null;
    }
    
}
