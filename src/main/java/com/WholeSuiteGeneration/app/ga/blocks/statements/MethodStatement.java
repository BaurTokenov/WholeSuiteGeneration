package com.WholeSuiteGeneration.app.ga.blocks.statements;

public class MethodStatement extends Statement {
  String methodType, objectName, methodName, name;
  String[] parameterTypes;

  public MethodStatement(String methodType, String objectName, String methodName, String[] parameterTypes) {
    this.methodName = methodName;
    this.methodType = methodType;
    // on what object we are calling this method
    this.objectName = objectName;
    this.parameterTypes = parameterTypes;
    this.name = generateVariableName();
  }

  @Override
  public String Translate() {
    // TODO Auto-generated method stub
    if (methodType.equals("void")) {
      return String.format("%s.%s()", objectName, methodName);
    } else {
      return String.format("%s %s = %s.%s()", methodType, name, objectName, methodName);
    }
  }
}
