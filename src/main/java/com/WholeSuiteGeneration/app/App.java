package com.WholeSuiteGeneration.app;

import com.WholeSuiteGeneration.app.ga.TestExecutor;
import com.WholeSuiteGeneration.app.ga.blocks.TestCase;
import com.WholeSuiteGeneration.app.ga.blocks.TestSuite;

public class App {
    public static void main(String[] args) {
        String classPath = "com.WholeSuiteGeneration.app.testClasses." + args[0];
        String className = args[0];
        int maxTestLen = 15;
        int suiteMaxLen = 20;
        TestSuite checkTestSuite = new TestSuite(suiteMaxLen, maxTestLen, className, classPath);
        System.out.println(checkTestSuite.getCode());
        // TestCase checkTestCase = new TestCase(maxTestLength, className, classPath);
        // System.out.println(checkTestCase.getCode());
        // TestExecutor cur = new TestExecutor();
        // cur.runTest(checkTestCase.getCode(), className);
    }
}
