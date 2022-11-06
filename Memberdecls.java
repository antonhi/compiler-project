public class Memberdecls extends Token {

    private final FielddeclList fielddeclList;
    private final MethoddeclList methoddeclList;

    public Memberdecls () {
        this.fielddeclList = new FielddeclList();
        this.methoddeclList = new MethoddeclList();
    }

    public Memberdecls fieldsPrepend(Fielddecl fielddecl) {
        fielddeclList.prepend(fielddecl);
        return this;
    }

    public Memberdecls methodsPrepend(Methoddecl methoddecl) {
        methoddeclList.prepend(methoddecl);
        return this;
    }

    @Override
    public String toString(int t) {
        return fielddeclList.toString(t) + (methoddeclList.isEmpty() ? "" : (fielddeclList.isEmpty() ? "" : "\n") + methoddeclList.toString(t));
    }
    
}
