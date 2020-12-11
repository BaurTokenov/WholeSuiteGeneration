package com.WholeSuiteGeneration.app.ga.blocks;

import java.util.ArrayList;

import com.WholeSuiteGeneration.app.ga.blocks.statements.Statement;
import com.WholeSuiteGeneration.app.ga.generators.RandomTestCaseGenerator;

public class TestCase {
    public ArrayList<Statement> statements;
    public TestCaseScope scope;

    public static void main(String[] args) {

    }

    public TestCase(int maxLen, String classPath) {
        this.scope = new TestCaseScope(classPath);
        this.statements = new ArrayList<Statement>();
        RandomTestCaseGenerator randomTestGenerator = new RandomTestCaseGenerator();
        randomTestGenerator.generateTestCase(this.statements, maxLen, this.scope);
    }
}
