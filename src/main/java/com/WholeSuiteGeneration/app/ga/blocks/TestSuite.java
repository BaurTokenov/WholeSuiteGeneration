package com.WholeSuiteGeneration.app.ga.blocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.lang.reflect.*;
import java.util.HashSet;

public class TestSuite implements Comparator<TestSuite> ,Comparable<TestSuite>{
    public ArrayList<TestCase> tests;
    String className;
    String classPath;
    int suiteMaxLen;

    public TestSuite(int suiteMaxLen, int maxTestLen, String className, String classPath) {
        this.tests = new ArrayList<TestCase>();
        this.suiteMaxLen = suiteMaxLen;
        this.className = className;
        this.classPath = classPath;
        for (int i = 0; i < suiteMaxLen; ++i) {
            TestCase newTestCase = new TestCase(maxTestLen, className, classPath);
            this.tests.add(newTestCase);
        }
    }

    

    public double calculateFitness() {
        Set<String> executedMethods = new HashSet<String>();
        for (TestCase test : this.tests) {
            executedMethods.addAll(test.calculateCoverage());
        }
        try {
            Class cls = Class.forName(this.classPath);
            Method m[] = cls.getDeclaredMethods();
            int totalMethods = m.length;
            System.out.println("total Methods: " + totalMethods + "executed Methods: " + executedMethods.size());
            System.out.println("All methods:");
            for (int i = 0; i < m.length; ++i) {
                String methodName = m[i].getName();                
                System.out.println(methodName);
            }
            System.out.println("executed methods:");
            for (String executedMethodName: executedMethods) {
                System.out.println(executedMethodName);
            }

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

    @Override
    public int compareTo(TestSuite o) {
        int ret = 1;
        if (this.calculateFitness() - o.calculateFitness() < 0)
            ret = -1;
        else if (this.calculateFitness() - o.calculateFitness() == 0)
            ret = 0;
        return ret;
    }

    @Override
    public int compare(TestSuite o1, TestSuite o2) {
        int ret = 1;
        if (o1.calculateFitness() - o2.calculateFitness() < 0)
            ret = -1;
        else if (o1.calculateFitness() - o2.calculateFitness() == 0)
            ret = 0;
        return ret;
    }
}
