import java.util.ArrayList;
import java.util.List;

public class MethoddeclList extends Token {

    private List<Methoddecl> methoddecls;

    public MethoddeclList () {
       methoddecls = new ArrayList<>();
    }

    public MethoddeclList prepend(Methoddecl methoddecl) {
        methoddecls.add(0, methoddecl);
        return this;
    }

    @Override
    public String toString(int t) {
        String result = "";
        for (Methoddecl methoddecl : methoddecls) {
            result += methoddecl.toString(t);
        }
        return result;
    }
    
}
