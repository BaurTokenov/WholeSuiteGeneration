package com.WholeSuiteGeneration.app.ga.blocks;

import java.util.ArrayList;
import java.lang.reflect.*;

import com.WholeSuiteGeneration.app.ga.blocks.statements.*;

public class TestCaseScope {

    private int nameIdx;
    public ArrayList<Statement> availableStatements;

    public TestCaseScope(String className, String classPath) {
        nameIdx = 0;
        populateSet(className, classPath);
    }

    private void populateSet(String className, String classPath) {
        availableStatements = new ArrayList<Statement>();
        availableStatements.add(new PrimitiveStatement("int", null));
        availableStatements.add(new PrimitiveStatement("boolean", null));
        availableStatements.add(new PrimitiveStatement("String", null));
        availableStatements.add(new PrimitiveStatement("float", null));
        availableStatements.add(new PrimitiveStatement("double", null));
        // add class constructor as an available statement
        // add class methods as an available statement

        Class cls;

        try {
            cls = Class.forName(classPath);
            // TODO: add Constructors to set
            Constructor ctorlist[] = cls.getDeclaredConstructors();
            for (int i = 0; i < ctorlist.length; i++) {
                Constructor ct = ctorlist[i];
                System.out.println(ct);
                // String name = ct.getName();
                Class p[] = ct.getParameterTypes();
                String pvec[] = new String[p.length];

                for (int j = 0; j < p.length; j++) {
                    System.out.println(pvec[j]);
                    pvec[j] = p[j].toString();
                }
                ConstructorStatement cs = new ConstructorStatement(className, pvec, classPath);
                availableStatements.add(cs);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // TODO: add static methods

        // Method m[] = cls.getDeclaredMethods();
        // for (int i = 0; i < m.length; ++i) {
        // System.out.println(m[i].toString());
        // }
    }

    public String GenerateVariableName() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        String digits = "0123456789";
        String ans = "";
        for (int i = 0; i < 3; ++i) {
            int index = (int) (letters.length() * Math.random());
            ans += letters.charAt(index);
        }
        for (int i = 0; i < 3; ++i) {
            int index = (int) (digits.length() * Math.random());
            ans += digits.charAt(index);
        }
        return ans;
    }

}
