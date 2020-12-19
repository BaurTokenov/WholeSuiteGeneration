package com.WholeSuiteGeneration.app.ga;

import java.util.Random;
import com.WholeSuiteGeneration.app.ga.blocks.*;
import com.WholeSuiteGeneration.app.ga.blocks.statements.Statement;

public class TestCaseMutator {
  
  public void mutateTestCase(TestCase testCase) {
    Random r = new Random();
    int mutationType = r.nextInt(3);    
    switch (mutationType) {
        case 0:
          // remove
          int len = testCase.statements.size();
          float probability = 1.0f/len;
          int i = 0;
          while (i < testCase.statements.size()) {
            Statement cur = testCase.statements.get(i);            
            if (r.nextFloat() < probability) {
              testCase.statements.remove(i);
            } else {
              i += 1;
            }
          }
          break;
        case 1:
          // insert
          if (testCase.statements.size() < testCase.maxLen) {
            TestCaseScope scope = testCase.scope;            
            int scopeSize = scope.availableStatements.size();
            Statement randomStatement;
            try {
              randomStatement = (Statement) (scope.availableStatements.get(r.nextInt(scopeSize)).clone());
              randomStatement.setName(scope.GenerateVariableName());
              randomStatement.assignRandomValues();
              scope.updateScope(randomStatement);
              testCase.statements.add(randomStatement);
            } catch (CloneNotSupportedException e) {
              e.printStackTrace();
            }
          }
          break;
        case 2:
          break;
    }    
  }
}