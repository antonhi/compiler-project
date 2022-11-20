import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SymbolTable {

   private List<HashMap<String, TypeData>> table;

   public SymbolTable() {
       table = new ArrayList<>();
       table.add(new HashMap<>());
   }

   public TypeData get(String s) throws CompilerException {
    for (int i = table.size()-1; i >= 0; --i) {
        if (table.get(i).containsKey(s)) {
            return table.get(i).get(s);
        }
    }
    throw new CompilerException("Error: variable not declared " + s);
  }

  public void addElement(String id, String t, boolean isFinal, boolean isArray, List<TypeData> args) throws CompilerException {
    if (table.get(table.size()-1).containsKey(id)) {
        throw new CompilerException("Error: tried to redeclare variable " + id);
    }
    table.get(table.size()-1).put(id, new TypeData(t, isFinal, isArray, args));
    
    return;
  }

  public void startScope() { table.add(new HashMap<>()); }
  public void endScope() { table.remove(table.size()-1); }

  public String toString() {
      String output = "";
      for (HashMap<String, TypeData> scope : table) {
        for (String key : scope.keySet()) {
            output += key + ": " + scope.get(key).toString() + "\n";
        }
        output += "\t";
      }
      return output;
  }

}
