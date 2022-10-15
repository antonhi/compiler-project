public class ReturnStatement extends Statement {

    @Override
    public String toString(int t) {
        return getTabs(t) + "return;\n";
    }
    
}
