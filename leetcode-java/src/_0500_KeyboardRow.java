import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * FileName: KeyboardRow_500.java
 * Description: 对键盘上的字母建立一个Hash表，在同一行上的字母的哈希值相同，则可判断出结果
 * Authors: wangbiwen
 * Date: 17-3-2
 */
public class _0500_KeyboardRow {
    public String[] findWords(String[] words) {
        String[] alphabet = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> alphabetMap = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            for (char c : alphabet[i].toCharArray()) {
                alphabetMap.put(c, i);
            }
        }

        List<String> result = new LinkedList<>();
        for (String word : words) {
            int flag = alphabetMap.get(word.toLowerCase().charAt(0));
            for (char c : word.toLowerCase().toCharArray()) {
                if (flag != alphabetMap.get(c)) {
                    flag = -1;
                    break;
                }
            }
            if (flag != -1) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        _0500_KeyboardRow keyboardRow = new _0500_KeyboardRow();
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] result = keyboardRow.findWords(words);
        for (String word : result) {
            System.out.println(word);
        }
    }
}
