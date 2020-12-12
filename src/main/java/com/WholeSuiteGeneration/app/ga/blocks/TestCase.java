package com.WholeSuiteGeneration.app.ga.blocks;

import java.util.ArrayList;

import com.WholeSuiteGeneration.app.ga.blocks.statements.Statement;
import com.WholeSuiteGeneration.app.ga.generators.RandomTestCaseGenerator;

public class TestCase {
    public ArrayList<Statement> statements;
    public TestCaseScope scope;
    private Set<string> coverageSet;
    private string classPath;

    public TestCase(int maxLen, String classPath) {
        this.scope = new TestCaseScope(classPath);
        this.statements = new ArrayList<Statement>();
        this.coverageSet = new Set<string>();
        this.classPath = classPath;
        RandomTestCaseGenerator randomTestGenerator = new RandomTestCaseGenerator();
        randomTestGenerator.generateTestCase(this.statements, maxLen, this.scope);
    }

    public void mutate()

    public Set<string> GetSetCoverage(){
        return coverageSet;
    }
}
