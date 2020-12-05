package ga.blocks.statements;

public class PrimitiveStatement extends Statement {
  // left hand side and the right hand side of a primitive statement
  // i.e. int a = fdsfsdf
  // both are represented using strings since there are no dynamic types in Java
  String type;
  String value;
  String name;

  public static void main(String[] args) {
    System.out.println(generateVariableName());
  }

  public PrimitiveStatement(String type, String value) {
    this.name = generateVariableName();
    this.type = type;
    this.value = value;
    // TODO: Push to pool of available statements
    // TODO: pool of integers, pool of booleans
    // OR NOT TODO
    // THATS THE QUESTION
  }

  @Override
  public String ToString() {
    return String.format("%s %s = $s", type, name, value);
  }
}
