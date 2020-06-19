import java.util.Queue;

/**
 * Created by goto456 on 2020/5/30.
 */
public class _0151_ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            // 此判断不可少，否则连续多个空格时会报错
            if (!strings[i].equals("")) {
                result.append(strings[i]).append(" ");
            }
        }
        return result.toString().trim();
    }
}
