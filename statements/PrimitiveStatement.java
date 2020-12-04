package statements;

public class PrimitiveStatement extends Statement {
  // left hand side and the right hand side of a primitive statement
  // i.e. int a = fdsfsdf
  // both are represented using strings since there are no dynamic types in Java
  String type;
  String value;
  String name;

  public static void main(String[] args) {
    System.out.println(generateVariableName());
  }

  public PrimitiveStatement(String type, String value) {
    name = generateVariableName();
  }

  private static String generateVariableName() {
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
