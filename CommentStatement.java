public class CommentStatement extends Statement {

    private String comment;

    public CommentStatement (String comment) {
        this.comment = comment;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + comment;
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        return null;
    }
    
}
