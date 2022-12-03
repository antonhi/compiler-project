import java.util.ArrayList;

public class ExpressionFielddecl extends Fielddecl {

    private final boolean optionalFinal;
    private final Type type;
    private final String id;
    private final OptionalExpr optionalExpr;

    public ExpressionFielddecl (boolean optionalFinal, Type type, String id, OptionalExpr optionalExpr) {
        this.optionalFinal = optionalFinal;
        this.type = type;
        this.id = id;
        this.optionalExpr = optionalExpr;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + (optionalFinal ? "final " : "") + type.toString(0) + " " + id + (optionalExpr.populated() ? " " + optionalExpr.toString(0) : "") + ";\n";
    }

    @Override
    public TypeData typeCheck() throws CompilerException {
        symbolTable.addElement(id, type.getType(), optionalFinal, false, new ArrayList<>());
        if (optionalExpr != null && optionalExpr.populated()) {
            optionalExpr.typeCheck();
            if (!getTypeDataFromType().same(optionalExpr.typeCheck())) {
                throw new CompilerException("Error: Cannot assign a value of type [" + optionalExpr.typeCheck().toString() + "] to [" + getTypeDataFromType().toString() + "]");
            }
        }
        return null;
    }

    private TypeData getTypeDataFromType() {
        return new TypeData(type.getType(), false, type.isArray(), new ArrayList<>());
    }
    
}
