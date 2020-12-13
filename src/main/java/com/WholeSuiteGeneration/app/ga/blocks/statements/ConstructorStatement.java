package com.WholeSuiteGeneration.app.ga.blocks.statements;

import com.WholeSuiteGeneration.app.ga.blocks.TestCaseScope;

public class ConstructorStatement extends Statement {
  String className, classPath;
  String[] parameterTypes;
  String name;

  public ConstructorStatement(String className, String[] p, String classPath) {
    this.className = className;
    this.parameterTypes = p;
    this.name = generateVariableName();
    this.classPath = classPath;
  }

  @Override
  public String Translate() {
    return String.format("%s %s = new %s()", className, name, className);
  }

  public String getClassPath() {
    return classPath;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }
}
