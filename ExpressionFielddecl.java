public class ExpressionFielddecl extends Fielddecl {

    private final OptionalFinal optionalFinal;
    private final Type type;
    private final String id;
    private final OptionalExpr optionalExpr;

    public ExpressionFielddecl (OptionalFinal optionalFinal, Type type, String id, OptionalExpr optionalExpr) {
        this.optionalFinal = optionalFinal;
        this.type = type;
        this.id = id;
        this.optionalExpr = optionalExpr;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + optionalFinal.toString(0) + " " + type.toString(0) + " " + id + " " + optionalExpr.toString(0) + ";\n";
    }
    
}
