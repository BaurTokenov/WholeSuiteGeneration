package com.WholeSuiteGeneration.app.ga.blocks;

import java.util.ArrayList;
import java.lang.reflect.*;

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
        // add class constructor as an available statement
        // add class methods as an available statement 
        Class cls = Class.forName(classPath);
        Method m[] = cls.getDeclaredMethods();
        for (int i = 0; i < m.length; ++i) {
            System.out.println(m[i].toString());
        }
        
        // TODO: add Constructors to set
        Constructor ctorlist[] =  cls.GetDeclaredConstructors();
        for (int i = 0; i < ctorlist.length; i++) {
            Constructor ct = ctorlist[i];
            String name = ct.getName();
            Class p[] = ct.getDeclaredMethods();
            String pvec[] = new String[p.length];
            
            for (int i = 0; i < p.length; i++){
                pvec[i] = p[i].toString();
            }

            ConstructorStatement cs = new ConstructorStatement(name, p);
          }

          //TODO: add static methods
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
