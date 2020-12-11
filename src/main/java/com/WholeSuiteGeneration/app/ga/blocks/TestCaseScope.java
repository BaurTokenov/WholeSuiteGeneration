package com.WholeSuiteGeneration.app.ga.blocks;

import java.util.ArrayList;

import com.WholeSuiteGeneration.app.ga.blocks.statements.*;

public class TestCaseScope {

    private int nameIdx;
    public ArrayList<Statement> availableStatements;

    public TestCaseScope(String classPath) {
        nameIdx = 0;
        populateSet(classPath);
    }

    private void populateSet(String classPath) {
        availableStatements = new ArrayList<Statement>();
        availableStatements.add(new PrimitiveStatement("int", null));
        availableStatements.add(new PrimitiveStatement("bool", null));
        availableStatements.add(new PrimitiveStatement("String", null));
        availableStatements.add(new PrimitiveStatement("float", null));
        availableStatements.add(new PrimitiveStatement("double", null));

        // Class c = Class.forName(classPath);
        // Method m[] = c.getDeclaredMethods();
        // for (int i = 0; i < m.length; ++i) {
        // System.out.println(m[i].toString());
        // }
    }

    public String GenerateVariableName() {
        String letters = "abcdefghijklmnopqrstuvxyz";
        String name = "";
        int key = nameIdx++;
        while (key > 0) {
            name += letters.charAt(key % 26);
            key /= 26;
        }
        return name;
    }

}
