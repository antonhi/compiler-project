import java.util.ArrayList;
import java.util.List;

public class PrintList extends Token {
    private List<Expression> expressions;

    public PrintList() {
        expressions = new ArrayList<>();
    }

    public PrintList prepend(Expression expression) {
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
