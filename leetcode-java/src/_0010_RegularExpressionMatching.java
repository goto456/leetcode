/**
 * Created by goto456 on 2018/11/13.
 */
public class _0010_RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // 表示第一个字符是否匹配上
        boolean first_match = (s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        // 如果pattern是"x*"类型的话,那么pattern每次要两个两个的减少。否则,就是一个一个的减少
        if (p.length() == 1 || p.charAt(1) != '*') {
            return first_match && isMatch(s.substring(1), p.substring(1));
        } else {
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        }
    }
}
