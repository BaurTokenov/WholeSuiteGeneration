package com.WholeSuiteGeneration.app.ga;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import com.WholeSuiteGeneration.app.ga.blocks.*;

public class Crossover {
    /**
     * Most ambitios crossover in programming history
     */
    static void doTestSuiteCrossover(TestSuite tsa, TestSuite tsb){
        Random rm = new Random(Calendar.getInstance().getTime().getTime());
        int idx = rm.nextInt(Math.min(tsa.tests.size(), tsb.tests.size()));
        ArrayList<TestCase> tsa1 = new ArrayList<>(tsa.tests.subList(0, idx));
        ArrayList<TestCase> tsa2 = new ArrayList<>(tsa.tests.subList(idx, tsa.tests.size()));
        ArrayList<TestCase> tsb1 = new ArrayList<>(tsb.tests.subList(0, idx));
        ArrayList<TestCase> tsb2 = new ArrayList<>(tsb.tests.subList(idx, tsb.tests.size()));

        tsa1.addAll(tsb2);
        tsb1.addAll(tsa2);
        tsa.tests = tsa1;
        tsb.tests = tsb2;
    }
    
}
