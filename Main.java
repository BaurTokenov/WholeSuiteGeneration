import testClasses.TestStack;

import ga.blocks.TestCase;
import ga.blocks.statements.*;

public class Main {
  public static void main(String[] args) {
    TestCase checkTestCase = new TestCase(5, "bauka");
    for (Statement cur : checkTestCase.statements) {
      System.out.println(cur.Translate());
    }
  }

}
