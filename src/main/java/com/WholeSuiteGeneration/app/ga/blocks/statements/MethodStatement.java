package com.WholeSuiteGeneration.app.ga.blocks.statements;

import java.util.*;

public class MethodStatement extends Statement {
  String methodType, objectName, methodName, name;
  String[] parameters;

  public MethodStatement(String methodType, String objectName, String methodName, String[] types) {
    this.methodName = methodName;
    this.methodType = methodType;
    // on what object we are calling this method
    this.objectName = objectName;
    // this.parameters = parameters;
    populateParameters(types);
    this.name = generateVariableName();
  }

  @Override
  public String Translate() {
    // TODO Auto-generated method stub

    String ret = "";
    if (!methodType.equals("void")) {
      ret += String.format("%s %s = ", methodType, name);
    }

    ret += objectName + "." + methodName + "(";

    for (int i = 0; i < parameters.length - 1; i++) {
      ret += parameters[i] + ", ";
    }

    if (parameters.length == 0)
      ret += ")";
    else
      ret += parameters[parameters.length - 1] + ")";

    return ret;

  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.objectName;
  }

  private void populateParameters(String[] types) {
    this.parameters = new String[types.length];
    for (int i = 0; i < types.length; i++) {
      this.parameters[i] = getRandomVal(types[i]);
    }
  }

  private String getRandomVal(String type) {
    int bound = 1 << 15;
    Random r = new Random();
    String value = "";
    switch (type) {
      case "int":
        value = (bound - 2 * r.nextInt(bound)) + "";
        break;
      case "boolean":
        value = r.nextBoolean() + "";
        break;
      case "float":
        value = r.nextFloat() + "f";
        break;
      case "double":
        value = r.nextDouble() + "";
        break;
      case "String":
        value = "\"Bauka\"";
        break;
      default:
        break;
    }
    return value;
  }

}
