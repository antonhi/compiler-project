import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SymbolTable {

   private List<HashMap<String, TypeData>> table;
   private List<TypeData> returnTable;

   public SymbolTable() {
       table = new ArrayList<>();
       returnTable = new ArrayList<>();
       table.add(new HashMap<>());
   }

   public TypeData get(String s) throws CompilerException {
    for (int i = table.size()-1; i >= 0; --i) {
        if (table.get(i).containsKey(s)) {
            return table.get(i).get(s);
        }
    }
    throw new CompilerException("Error: element not declared " + s);
  }

  public void addElement(String id, String t, boolean isFinal, boolean isArray, List<TypeData> args) throws CompilerException {
    if (table.get(table.size()-1).containsKey(id)) {
        throw new CompilerException("Error: tried to redeclare element " + id);
    }
    table.get(table.size()-1).put(id, new TypeData(t, isFinal, isArray, args));
    
    return;
  }

  public void startScope() {
     table.add(new HashMap<>());
  }

  public void addReturnType(TypeData type) {
    returnTable.add(type);
  }

  public void endScope(TypeData returnType) throws CompilerException {
    if (!returnTable.isEmpty()) {
      if ((returnType == null && !returnTable.get(returnTable.size()-1).getType().equals("void")) || (returnType != null && !returnTable.get(returnTable.size()-1).same(returnType))) {
        throw new CompilerException("Error: Return type [" + returnTable.get(returnTable.size()-1).toString() + "] expected but [" + (returnType == null ? "void" : returnType.toString()) + "] received");
      }
      returnTable.remove(returnTable.size()-1);
    }
    table.remove(table.size()-1);
  }

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
