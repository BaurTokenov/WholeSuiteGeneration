import testClasses.TestStack;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {
    try {
      runProcess("pwd");
      System.out.println("**********");
      runProcess("javac -cp testClasses testClasses/TestStack.java");
      System.out.println("**********");
      runProcess("java testClasses/TestStack HI BAUKA");
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
