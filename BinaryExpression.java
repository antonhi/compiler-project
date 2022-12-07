import java.util.ArrayList;

public class BinaryExpression extends Expression {

    private Expression expression1, expression2;
    private Binaryop binaryop;

    public BinaryExpression (Expression expression1, Expression expression2, Binaryop binaryop) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.binaryop = binaryop;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + "(" + expression1.toString(0) + " " + binaryop.toString(0) + " " + expression2.toString(0) + ")";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        if (binaryop.getValue().equals("+") || binaryop.getValue().equals("-") || binaryop.getValue().equals("*") || binaryop.getValue().equals("/")) {
            if (expression1.typeCheck().getType().equals("int")) {
                if (expression2.typeCheck().getType().equals("int")) {
                    return new TypeData("int", false, false, new ArrayList<>());
                } else if (expression2.typeCheck().getType().equals("float")) {
                    return new TypeData("float", false, false, new ArrayList<>());
                }
            } else if (expression1.typeCheck().getType().equals("float")) {
                if (expression2.typeCheck().getType().equals("int")) {
                    return new TypeData("float", false, false, new ArrayList<>());
                } else if (expression2.typeCheck().getType().equals("float")) {
                    return new TypeData("float", false, false, new ArrayList<>());
                }
            } else if (expression1.typeCheck().getType().equals("string") && expression2.typeCheck().getType().equals("string") && binaryop.getValue().equals("+")) {
                return new TypeData("string", false, false, new ArrayList<>());
            } else {
                switch (binaryop.getValue()) {
                    case "+":
                    throw new CompilerException("Error: Could not add " + expression1.typeCheck().getType() + " and " + expression2.typeCheck().getType());
                    case "-":
                    throw new CompilerException("Error: Could not subtract " + expression1.typeCheck().getType() + " and " + expression2.typeCheck().getType());
                    case "*":
                    throw new CompilerException("Error: Could not multiply " + expression1.typeCheck().getType() + " and " + expression2.typeCheck().getType());
                    case "/":
                    throw new CompilerException("Error: Could not divide " + expression1.typeCheck().getType() + " and " + expression2.typeCheck().getType());
                }
                throw new CompilerException("Error: Could not add, subtract, multiply, or divide " + expression1.typeCheck().getType() + " and " + expression2.typeCheck().getType());
            }
        }
        if (binaryop.getValue().equals("<") || binaryop.getValue().equals(">") || binaryop.getValue().equals("<=") || binaryop.getValue().equals(">=") || binaryop.getValue().equals("==") || binaryop.getValue().equals("<>")) {
            if ((expression1.typeCheck().getType().equals("float") || expression1.typeCheck().getType().equals("int")) && (expression2.typeCheck().getType().equals("float") || expression2.typeCheck().getType().equals("int"))) {
                return new TypeData("bool", false, false, new ArrayList<>());
            } else {
                throw new CompilerException("Error: Could not compare non-float or -int expressions");
            }
        }
        if (binaryop.getValue().equals("&&") || binaryop.getValue().equals("||")) {
            return new TypeData("bool", false, false, new ArrayList<>());
        }
        return expression1.typeCheck(); 
    }
    
}
