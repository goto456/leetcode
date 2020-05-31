/**
 * Created by goto456 on 2020/5/28.
 */
public class _0058_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if (strings.length == 0) {
            return 0;
        }
        return strings[strings.length - 1].length();
    }

    /**
     * 从后往前遍历
     */
    public int lengthOfLastWord2(String s) {
        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }
        if (right < 0) {
            return 0;
        }
        int left = right;
        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }
        return right - left;
    }
}
