public class PrintLineStatement extends Statement {

    private PrintLineList expressions;

    public PrintLineStatement (PrintLineList expressions) {
        this.expressions = expressions;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "printline (" + expressions.toString(0) + ");\n";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        expressions.typeCheck();
        return null;
    }
    
}
