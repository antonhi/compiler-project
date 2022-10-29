public class Memberdecls extends Token {

    private final FielddeclList fielddeclList;
    private final MethoddeclList methoddeclList;

    public Memberdecls (FielddeclList fielddeclList, MethoddeclList methoddeclList) {
        this.fielddeclList = fielddeclList;
        this.methoddeclList = methoddeclList;
    }

    @Override
    public String toString(int t) {
        return fielddeclList.toString(t) + "\n" + methoddeclList.toString(t);
    }
    
}
