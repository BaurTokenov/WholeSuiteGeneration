package com.WholeSuiteGeneration.app.ga.blocks;

import java.util.ArrayList;

public class TestSuite {
    ArrayList<TestCase> tests;
    public static double calculateFitness(TestSuite testSuite) {
        ArrayList <String> executedMethods;
        for (TestCase test:this.tests) {
            executedMethods.add(test.GetFloatCoverage);
        }
    }
    
}
