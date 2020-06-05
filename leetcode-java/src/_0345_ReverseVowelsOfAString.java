import java.util.HashSet;
import java.util.Set;

/**
 * Created by goto456 on 2020/6/5.
 */
public class _0345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isVowel(chars[i])) {
                i++;
            }
            while (i < j && !isVowel(chars[j])) {
                j--;
            }

            if (i >= j) {
                break;
            }

            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;

            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
