import java.util.ArrayList;
import java.util.List;

public class Args extends Token {

    private List<Expression> expressions;

    public Args() {
        expressions = new ArrayList<>();
    }

    public Args prepend(Expression expression) {
        expressions.add(0, expression);
        return this;
    }

    @Override
    public String toString(int t) {
        String result = "";
        for (Expression e : expressions) {
            result += e.toString(0) + ", ";
        }
        return result;
    }
    
}
