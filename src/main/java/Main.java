import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.letterCombinations("23");
        System.out.println();
    }


    HashMap<String, String> phoneNum = new HashMap<>();
    StringBuilder tmp = new StringBuilder();
    List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        phoneNum.put("2", "abc");
        phoneNum.put("3", "def");
        phoneNum.put("4", "ghi");
        phoneNum.put("5", "jkl");
        phoneNum.put("6", "mno");
        phoneNum.put("7", "pqrs");
        phoneNum.put("8", "tuv");
        phoneNum.put("9", "wxyz");

        backtracking(digits, 0);
        return res;
    }

    private void backtracking(String digits, int index) {
        if (index == digits.length()) {
            res.add(tmp.toString());
            return;
        }
        String numCharacters = phoneNum.get(String.valueOf(digits.charAt(index)));
        for (int i = 0; i < numCharacters.length(); i++) {
            tmp.append(numCharacters.charAt(i));
            backtracking(digits, index + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
