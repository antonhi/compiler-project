import java.util.ArrayList;
import java.util.List;

public class ArgdeclList extends Token {

    private List<Argdecl> argdecls;

    public ArgdeclList () {
        argdecls = new ArrayList<>();
    }

    public ArgdeclList prepend(Argdecl argdecl) {
        argdecls.add(0, argdecl);
        return this;
    }

    @Override
    public String toString(int t) {
        String result = "";
        int index = 0;
        for (Argdecl n : argdecls) {
            result += n.toString(0) + (++index == argdecls.size() ? "" : ", ");
        }
        return result;
    }
    
}
