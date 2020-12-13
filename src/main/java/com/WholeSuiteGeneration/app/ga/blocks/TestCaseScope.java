package com.WholeSuiteGeneration.app.ga.blocks;

import java.util.ArrayList;
import java.lang.reflect.*;

import com.WholeSuiteGeneration.app.ga.blocks.statements.*;

public class TestCaseScope {

    private int nameIdx;
    public ArrayList<Statement> availableStatements;
    private String classPath;

    public TestCaseScope(String className, String classPath) {
        nameIdx = 0;
        this.classPath = classPath;
        populateSet(className, classPath);
    }

    private void populateSet(String className, String classPath) {
        this.classPath = classPath;
        availableStatements = new ArrayList<Statement>();
        availableStatements.add(new PrimitiveStatement("int", null));
        availableStatements.add(new PrimitiveStatement("boolean", null));
        availableStatements.add(new PrimitiveStatement("String", null));
        availableStatements.add(new PrimitiveStatement("float", null));
        availableStatements.add(new PrimitiveStatement("double", null));
        // add class constructor as an available statement
        // add class methods as an available statement

        try {
            Class cls = Class.forName(classPath);
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

    }

    public String GenerateVariableName() {
        String letters = "abcdefghijklmnopqrstuvxyz";
        String ans = "";
        int cur = nameIdx++;
        do {
            ans += letters.charAt(cur % letters.length());
            cur /= letters.length();
        } while (cur > 0);
        return ans;
    }

    // TODO: add fields
    public void updateScope(Statement st) {
        if (st instanceof ConstructorStatement) {
            try {
                ConstructorStatement cs = (ConstructorStatement) st;
                Class cls = Class.forName(cs.getClassPath());
                Method m[] = cls.getDeclaredMethods();
                for (int i = 0; i < m.length; ++i) {
                    String methodType = m[i].getReturnType().toString();
                    String objectName = cs.getName();
                    String methodName = m[i].getName();
                    Class[] pt = m[i].getParameterTypes();
                    String[] parameterTypes = new String[pt.length];
                    for (int j = 0; j < pt.length; j++) {
                        parameterTypes[j] = pt[j].toString();
                    }
                    availableStatements.add(new MethodStatement(methodType, objectName, methodName, parameterTypes));
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("updateScope obosralsya");
            }

        }
    }

}
