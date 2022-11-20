public class ConstructorExpression extends Expression {

    private String id;

    public ConstructorExpression (String id) {
        this.id = id;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(" + id + "())";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        TypeData type = symbolTable.get(id);
        if (type == null || !type.isFunction() || type.getArgsAmount() != 0) {
            throw new CompilerException("Error: " + id + " cannot be constructed as it is undeclared, not a function, or requires parameters");
        }
        return type;
    }
    
}
