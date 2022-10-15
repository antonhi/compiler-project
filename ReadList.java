import java.util.ArrayList;
import java.util.List;

public class ReadList extends Token {

    private List<Name> names;

    public ReadList() {
        names = new ArrayList<>();
    }

    public ReadList prepend(Name name) {
        names.add(0, name);
        return this;
    }

    @Override
    public String toString(int t) {
        String result = "";
        for (Name n : names) {
            result += n.toString(0) + ", ";
        }
        return result;
    }
    
}
