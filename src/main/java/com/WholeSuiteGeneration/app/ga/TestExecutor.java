package com.WholeSuiteGeneration.app.ga;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestExecutor {
  public static void main(String[] args) {
    TestExecutor cur = new TestExecutor();
    cur.writeToExecutorFile("System.out.println(\"debil\");");
    cur.executeTest();
  }

  public double writeToExecutorFile(String code) {
    try {
      File myObj = new File("CurrentTest.java");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists");
      }
      FileWriter myWriter = new FileWriter("CurrentTest.java");
      String codePrefix = "package com.WholeSuiteGeneration.app.ga;\n" + "import com.WholeSuiteGeneration.app "
      // + className +
          + "\n" + "public class CurrentTest {\n" + "public static void main(String [] args) {\n";
      String codePostfix = "\n}\n}\n";
      code = codePrefix + code + codePostfix;
      myWriter.write(code);
      myWriter.close();
      System.out.println("Successfully wrote to the file");
      return 0.1;
    } catch (Exception e) {
      System.out.println("An error occured");
    }
    return 0.1;
  }

  public void executeTest() {
    try {
      runProcess("pwd");
      System.out.println("**********");
      runProcess("java CurrentTest.java");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void printLines(String cmd, InputStream ins) throws Exception {
    String line = null;
    BufferedReader in = new BufferedReader(new InputStreamReader(ins));
    while ((line = in.readLine()) != null) {
      System.out.println(cmd + " " + line);
    }
  }

  private static void runProcess(String command) throws Exception {
    Process pro = Runtime.getRuntime().exec(command);
    printLines(command + " stdout:", pro.getInputStream());
    printLines(command + " stderr:", pro.getErrorStream());
    pro.waitFor();
    System.out.println(command + " exitValue() " + pro.exitValue());
  }
}
