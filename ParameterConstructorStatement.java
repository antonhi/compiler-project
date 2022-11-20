import java.util.List;

public class ParameterConstructorStatement extends Statement {

    private String id;
    private Args args;

    public ParameterConstructorStatement (String id, Args args) {
        this.id = id;
        this.args = args;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + id + "(" + args.toString(0) + ");\n";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        TypeData type = symbolTable.get(id);
        List<TypeData> argTypes = args.getTypes();
        if (!type.isFunction() || type.getArgsAmount() != argTypes.size()) {
            throw new CompilerException("Error: " + id + " cannot be constructed as it is undeclared, not a function, or requires " + type.getArgsAmount() + " arguments while " + argTypes.size() + " arguments were passed in");
        }
        int index = 0;
        for (TypeData t : argTypes) {
            if (!t.getType().equals(type.getArgsList().get(index).getType())) {
                throw new CompilerException("Error: " + id + " cannot be constructed as the argument " + t.getType() + " does not match the expected argument type " + type.getArgsList().get(index).getType());
            }
        }
        return type;
    }
    
}
