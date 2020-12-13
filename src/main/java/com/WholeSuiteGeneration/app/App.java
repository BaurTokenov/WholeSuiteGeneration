package com.WholeSuiteGeneration.app;

import com.WholeSuiteGeneration.app.ga.TestExecutor;
import com.WholeSuiteGeneration.app.ga.blocks.TestCase;

public class App {
    public static void main(String[] args) {
        String classPath = "com.WholeSuiteGeneration.app.testClasses." + args[0];
        String className = args[0];
        int maxTestLength = 15;
        TestCase checkTestCase = new TestCase(maxTestLength, className, classPath);
        System.out.println(checkTestCase.getCode());
        TestExecutor cur = new TestExecutor();
        cur.runTest(checkTestCase.getCode(), className);
    }
}
