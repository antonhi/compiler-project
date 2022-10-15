public class PrintLineList extends Token {

    private PrintList expressions;

    public PrintLineList() {
        expressions = null;
    }

    public PrintLineList (PrintList expressions) {
        this.expressions = expressions;
    }

    @Override
    public String toString(int t) {
        return expressions == null ? "" : expressions.toString(0);
    }
    
}
