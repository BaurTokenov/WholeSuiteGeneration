package com.WholeSuiteGeneration.app.ga.blocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class TestSuite {
    ArrayList<TestCase> tests;

    public double calculateFitness(TestSuite testSuite) {
        Set<String> executedMethods = Collections.<String>emptySet();
        for (TestCase test : this.tests) {
            executedMethods.addAll(test.GetSetCoverage());
        }
        return 0.95;
    }

}
