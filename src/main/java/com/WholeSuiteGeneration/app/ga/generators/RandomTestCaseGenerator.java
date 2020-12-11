package com.WholeSuiteGeneration.app.ga.generators;

import java.util.Random;

import com.WholeSuiteGeneration.app.ga.blocks.TestCaseScope;
import com.WholeSuiteGeneration.app.ga.blocks.statements.Statement;

import java.util.ArrayList;

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
