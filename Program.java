public class Program extends Token {

    private final String id;
    private final Memberdecls memberdecls;

    public Program (String id, Memberdecls memberdecls) {
        this.id = id;
        this.memberdecls = memberdecls;
    }

    public String toString(int t) {
        return "class " + id + " {\n" + memberdecls.toString(t+1) + "}";
    }
}
