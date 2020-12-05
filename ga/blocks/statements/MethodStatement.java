package ga.blocks.statements;

public class MethodStatement extends Statement {
  String methodType, objectName, methodName, name;
  String[] methodArguments;

  public MethodStatement(String methodType, String objectName, String methodName, String[] methodArguments) {
    this.methodName = methodName;
    this.methodType = methodType;
    this.objectName = objectName;
    this.methodArguments = methodArguments;
    this.name = generateVariableName();
  }

  @Override
  public String ToString() {
    // TODO Auto-generated method stub
    return String.format("%s %s = %s.%s()", methodType, name, objectName, methodName);
  }
}
