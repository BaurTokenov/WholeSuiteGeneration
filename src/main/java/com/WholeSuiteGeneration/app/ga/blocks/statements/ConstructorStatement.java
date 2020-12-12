package com.WholeSuiteGeneration.app.ga.blocks.statements;

public class ConstructorStatement extends Statement {
  String className;
  String[] parameterTypes;
  String name;
  
  public  

  public ConstructorStatement(String className, String[] args) {
    this.className = className;
    this.parameterTypes = args;
    this.name = generateVariableName();
  }

  @Override
  public String Translate() {
    return String.format("%s %s = new %s", className, name, className);
  }
//napishi che nado chtoby ne zabytb

  @Override
  public void updateScope(TestCaseScope tcs) {
		//TODO: add fields
		//TODO: add methods	
	}
}
