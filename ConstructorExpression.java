public class ConstructorExpression extends Expression {

    private String id;

    public ConstructorExpression (String id) {
        this.id = id;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(" + id + "())";
    }
    
}
