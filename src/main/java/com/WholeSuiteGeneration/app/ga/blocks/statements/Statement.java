package com.WholeSuiteGeneration.app.ga.blocks.statements;

public class Statement {

  public Statement() {
  }

  static String generateVariableName() {
    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
    String digits = "0123456789";
    String ans = "";
    for (int i = 0; i < 3; ++i) {
      int index = (int) (letters.length() * Math.random());
      ans += letters.charAt(index);
    }
    for (int i = 0; i < 3; ++i) {
      int index = (int) (digits.length() * Math.random());
      ans += digits.charAt(index);
    }
    return ans;

  }

  public String Translate() {
    return null;
  }

  public void assignRandomValues() {
  }

  public void setName(String name) {

  }
}
