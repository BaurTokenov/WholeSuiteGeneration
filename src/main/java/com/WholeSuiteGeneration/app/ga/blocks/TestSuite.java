package com.WholeSuiteGeneration.app.ga.blocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.lang.reflect.*;

public class TestSuite {
    ArrayList<TestCase> tests;
    String className;

    public TestSuite(int suiteMaxLen, int maxTestLen, String className, String classPath) {
        for (int i = 0; i < suiteMaxLen; ++i) {
            TestCase newTestCase = new TestCase(maxTestLen, className, classPath);
            tests.add(newTestCase);
        }
    }

    public double calculateFitness(TestSuite testSuite) {
        Set<String> executedMethods = Collections.<String>emptySet();
        for (TestCase test : this.tests) {
            executedMethods.addAll(test.calculateCoverage());
        }
        try {
            Class cls;
            cls = Class.forName(this.className);
            Method m[] = cls.getDeclaredMethods();
            int totalMethods = m.length;
            return executedMethods.size() * 1.0 / totalMethods;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return 0.95;
    }

    public String getCode() {
        String code = "";
        for (TestCase cur : this.tests) {
            code += cur.getCode() + ";\n";
        }
        return code;
    }

}
