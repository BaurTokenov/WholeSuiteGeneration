package com.WholeSuiteGeneration.app.ga.blocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import com.WholeSuiteGeneration.app.ga.blocks.statements.Statement;
import com.WholeSuiteGeneration.app.ga.generators.RandomTestCaseGenerator;

public class TestCase {
    public ArrayList<Statement> statements;
    public TestCaseScope scope;
    private Set<String> coverageSet;
    private String classPath;

    public TestCase(int maxLen, String className, String classPath) {
        this.scope = new TestCaseScope(className, classPath);
        this.statements = new ArrayList<Statement>();
        this.coverageSet = Collections.<String>emptySet();
        this.classPath = classPath;
        RandomTestCaseGenerator randomTestGenerator = new RandomTestCaseGenerator();
        randomTestGenerator.generateTestCase(this.statements, maxLen, this.scope);
    }

    // public void mutate()

    public String getCode() {
        String code = "";
        for (Statement cur : this.statements) {
            code += "\t" + cur.Translate() + ";\n";
        }
        return code;
    }

    public Set<String> GetSetCoverage() {
        return coverageSet;
    }
}
