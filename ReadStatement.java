public class ReadStatement extends Statement {

    private ReadList names;

    public ReadStatement (ReadList names) {
        this.names = names;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "read (" + names.toString(0) + ");\n";
    }
    
}
