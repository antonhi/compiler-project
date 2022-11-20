public class AddStatement extends Statement {

    private Name name;

    public AddStatement (Name name) {
        this.name = name;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + name.toString(0) + "++;\n";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        TypeData type = name.typeCheck();
        if (type == null || type.isArray() || type.isFinal() || type.isFunction() || !(type.getType().equals("int") || type.getType().equals("float"))) {
            throw new CompilerException("Error: Cannot add to " + (type == null ? name.id : type.toString()));
        }
        return null;
    }
    
}
