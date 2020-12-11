package com.WholeSuiteGeneration.app;

import com.WholeSuiteGeneration.app.ga.blocks.TestCase;
import com.WholeSuiteGeneration.app.ga.blocks.statements.Statement;

public class App {
    public static void main(String[] args) {
        TestCase checkTestCase = new TestCase(5, "bauka");
        for (Statement cur : checkTestCase.statements) {
            System.out.println(cur.Translate());
        }
    }
}
