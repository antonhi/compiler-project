public class Type extends Token {

    private String type;

    public Type (String type) {
        this.type = type;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + type;
    }
    
}
