package ga.blocks.statements;

abstract public class Statement {

  static String generateVariableName() {
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

  abstract public String ToString();
}
