public class IntegerExpression extends Expression {

    private int number;

    public IntegerExpression (int number) {
        this.number = number;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + number;
    }
    
}
