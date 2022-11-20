public class CompilerException extends Exception {
    String error;
    public CompilerException(String s)
    {
        error = s;
    }

    public String toString()
    {
      return error;
    }
}