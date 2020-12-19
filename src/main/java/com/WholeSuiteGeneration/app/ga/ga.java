package com.WholeSuiteGeneration.app.ga;

import com.WholeSuiteGeneration.app.ga.blocks.*;
import java.util.ArrayList;
import java.util.Collections;



public class ga {
    public static TestSuite performGA(String targetClassPath, String targetClassName, int population, int generations, int maxTestSuiteLen, int maxTestCaseLen){
        ArrayList<TestSuite> testSuites = new ArrayList<>();
        for (int i = 0; i < population; i++){
            TestSuite temp = new TestSuite(maxTestSuiteLen, maxTestCaseLen, targetClassName, targetClassPath);
            testSuites.add(temp);
        }

        for (int i = 0; i < generations; i++){
            for (int j = 0; j < 10; j++){
                TestSuite p1 = Selection.tournamentSelection(Selection.randomSelection(testSuites, 4));
                TestSuite p2 = Selection.tournamentSelection(Selection.randomSelection(testSuites, 4));

                Crossover.doTestSuiteCrossover(p1, p2);
    
                testSuites.add(p1);
                testSuites.add(p2);
            }
            Collections.sort(testSuites);

            System.out.println(String.format("Generation: %d\nFirst Coverage: %s\nLast Coverage: %s\n\n", i, testSuites.get(0).calculateFitness(), testSuites.get(testSuites.size() - 1).calculateFitness()));

            testSuites = new ArrayList<>(testSuites.subList(testSuites.size() - population, testSuites.size()));
        }

        return testSuites.get(testSuites.size() - 1);
    }  
}