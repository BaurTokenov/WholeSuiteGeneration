package ga.generators;

import java.util.Random;
import java.util.ArrayList;
import ga.blocks.statements.*;
import ga.blocks.TestCaseScope;

public class RandomTestCaseGenerator {
  public void generateTestCase(ArrayList<Statement> statements, int maxLen, TestCaseScope scope) {
    Random rand = new Random();
    while (statements.size() < maxLen) {
      int scopeSize = scope.availableStatements.size();
      Statement randomStatement = scope.availableStatements.get(rand.nextInt(scopeSize));
      randomStatement.assignRandomValues();
      randomStatement.setName(scope.GenerateVariableName());
      statements.add(randomStatement);
    }
  }
}
