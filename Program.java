public class Program extends Token {
    private final StatementList program;
    public Program (StatementList statements) {
        this.program = statements;
    }

    public String toString(int t) {
        return "Program:\n" + program.toString(t+1) + "\n";
    }
}
