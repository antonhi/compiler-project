public class ReturnStatement extends Statement {

    @Override
    public String toString(int t) {
        return getTabs(t) + "return;\n";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        return null;
    }
    
}
