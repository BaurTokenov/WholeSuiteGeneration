package com.WholeSuiteGeneration.app;

public class Printer {
  String name;

  public Printer(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }

}
