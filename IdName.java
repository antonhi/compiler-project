public class IdName extends Name {

    public IdName(String id) {
        super(id);
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + id;
    }
    
}
