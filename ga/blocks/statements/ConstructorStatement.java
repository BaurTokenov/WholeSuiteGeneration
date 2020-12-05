package ga.blocks.statements;

public class ConstructorStatement extends Statement {
  String className;
  String[] parameters;
  String name;

  public ConstructorStatement(String className, String[] args) {
    this.className = className;
    this.parameters = args;
    this.name = generateVariableName();
  }

  @Override
  public String ToString() {
    return String.format("%s %s = new %s", className, name, className);
  }
}
