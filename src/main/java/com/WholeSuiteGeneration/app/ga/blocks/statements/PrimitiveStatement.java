package com.WholeSuiteGeneration.app.ga.blocks.statements;

import java.util.Random;

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
  public String Translate() {
    return String.format("%s %s = %s", type, name, value);
  }

  @Override
  public void assignRandomValues() {
    int bound = 1 << 15;
    Random r = new Random();
    System.out.println("Assigninig random value to " + this.name + " " + this.type + " " + this.value);
    switch (type) {
      case "int":
        value = (bound - 2 * r.nextInt(bound)) + "";
        break;
      case "bool":
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
    System.out.println("value is " + this.value);
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

}
