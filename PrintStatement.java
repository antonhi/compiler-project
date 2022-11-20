public class PrintStatement extends Statement {

    private PrintList expressions;

    public PrintStatement (PrintList expressions) {
        this.expressions = expressions;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "print (" + expressions.toString(0) + ");\n";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        expressions.typeCheck();
        return null;
    }
    
}
