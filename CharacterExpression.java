public class CharacterExpression extends Expression {

    private String character;

    public CharacterExpression (String character) {
        this.character = character;
    }

    @Override
    public String toString(int t) {
        return getTabs(t) + character;
    }
    
}
