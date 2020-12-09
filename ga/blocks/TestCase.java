package ga.blocks;

import ga.blocks.statements.*;
import ga.generators.RandomTestCaseGenerator;
import java.util.ArrayList;



public class TestCase {
    public ArrayList<Statement> statements;
    public TestCaseScope scope;

    public static void main(String[] args) {
        TestCase checkTestCase = new TestCase();
    }

    public TestCase(int maxLen, String classPath) {
        this.scope = new TestCaseScope(classPath);
        this.statements = new ArrayList<Statement>();
        generateTestCase(this.statements, maxLen, this.scope);        
    }    
}
