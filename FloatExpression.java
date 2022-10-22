public class FloatExpression extends Expression {

    private double number;

    public FloatExpression (double number) {
        this.number = number;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(" + number + ")";
    }
    
}
