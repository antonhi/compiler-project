public class IdExpressionName extends Name {

    private Expression expression;

    public IdExpressionName(String id, Expression expression) {
        super(id);
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + id + " [" + expression.toString(0) + "]";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        TypeData type = expression.typeCheck();
        if (type == null || !type.getType().equals("int")) {
            throw new CompilerException("Error: There must be a valid integer when passing in an index for an array");
        }
        TypeData type2 = symbolTable.get(id);
        if (type2 == null || !type2.isArray()) {
            throw new CompilerException("Error: " + id + " is not an array or has not been declared");
        }
        return type2;
    }
    
}
