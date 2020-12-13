package com.WholeSuiteGeneration.app.ga.blocks.statements;

import com.WholeSuiteGeneration.app.ga.blocks.TestCaseScope;

public class Statement implements Cloneable {

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
    System.out.println("generated name: " + ans);
    return ans;

  }

  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  public String Translate() {
    return null;
  }

  public void assignRandomValues() {
  }

  public void setName(String name) {

  }

  public void updateScope(TestCaseScope tcs) {

  }
}
