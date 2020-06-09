/**
 * 比较ASCii码解此题
 * Created by goto456 on 2020/5/30.
 */
public class _0125_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }
            // 大写字母和小写字母的ASCII码值差32
            if (Character.isLetter(s.charAt(i)) && Character.isLetter(s.charAt(j)) && Math.abs(s.charAt(i) - s.charAt(j)) == 32) {
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }
}
