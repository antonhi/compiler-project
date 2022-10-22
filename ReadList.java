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
        int index = 0;
        for (Name n : names) {
            result += n.toString(0) + (++index == names.size() ? "" : ", ");
        }
        return result;
    }
    
}
