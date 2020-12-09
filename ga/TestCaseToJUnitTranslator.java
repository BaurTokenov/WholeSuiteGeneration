package ga;

import ga.blocks.*;
import ga.blocks.statements.*;

public class TestCaseToJUnitTranslator {
    
    static String Translate(TestCase tc, String className){
        String res = getImports(className);
        for (Statement st: tc.statements){
            res += st.Translate() + '\n';
        }
        return res;
    }

    static String getImports(String className) {
      String codePrefix = "package ga;\n\n" + 
      "import testClasses." + className + ";\n" + 
      "public class CurrentTest {\n" + "public static void main(String [] args) {\n    ";
      return codePrefix;
    }

    static String getClosingBrackets() {
      return "\n}\n}\n";
    }

}
