package com.WholeSuiteGeneration.app.ga.blocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.WholeSuiteGeneration.app.ga.blocks.statements.MethodStatement;
import com.WholeSuiteGeneration.app.ga.blocks.statements.*;
import com.WholeSuiteGeneration.app.ga.generators.RandomTestCaseGenerator;

public class TestCase {
    public ArrayList<Statement> statements;
    public TestCaseScope scope;
    public int maxLen;
    private Set<String> coverageSet;
    private String classPath;

    public TestCase(int maxLen, String className, String classPath) {
        this.scope = new TestCaseScope(className, classPath);
        this.statements = new ArrayList<Statement>();
        this.coverageSet = new HashSet<String>();
        this.classPath = classPath;
        this.maxLen = maxLen;
        RandomTestCaseGenerator randomTestGenerator = new RandomTestCaseGenerator();
        randomTestGenerator.generateTestCase(this.statements, maxLen, this.scope);
        calculateCoverage();
    }

    // public void mutate()

    public String getCode() {
        String code = "";
        for (Statement cur : this.statements) {
            code += "\t" + cur.Translate() + ";\n";
        }
        return code;
    }

    public Set<String> calculateCoverage() {
        for (Statement cur : this.statements) {
            if (cur instanceof MethodStatement) {
                MethodStatement curMethodStatement = (MethodStatement) cur;
                this.coverageSet.add(curMethodStatement.methodName);
            }
        }
        return this.coverageSet;
    }

    public Set<String> getCoverage() {
        return this.coverageSet;
    }
}
