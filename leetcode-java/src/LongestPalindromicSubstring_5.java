/**
 * Created by goto456 on 2017/11/19.
 */
public class LongestPalindromicSubstring_5 {
    /**
     * 解法1：中心扩展方法
     */
    public static String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以s[i]为中心
            int len1 = expandAroundCenter(s, i, i);
            // 以s[i]和s[i+1]为中心
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > right - left + 1) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private static int expandAroundCenter(String s, int center1, int center2) {
        int left = center1;
        int right = center2;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * Manacher 算法，线性时间复杂度
     */
    public static String manacher(String s) {
        // 先将原字符串构造成特殊字符串
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < charArray.length; i++) {
            sb.append(charArray[i]);
            sb.append("#");
        }

        int maxCenter = 0;
        int maxRight = 0;
        int oriLen = 0;
        int oriRight = 0;

        int[] len = new int[sb.length()];
        for (int i = 0; i < len.length; i++) {
            // j是与关于maxCenter对称的点下标
            int j = 2 * maxCenter - i;
            len[i] = maxRight > i ? Math.min(len[j], maxRight - i) : 1;

            while (i + len[i] < sb.length() && i - len[i] >=0 && sb.charAt(i + len[i]) == sb.charAt(i - len[i])) {
                len[i]++;
            }

            // 更新最大记录及原字符串中对应的长度和最右位置
            if (maxRight - maxCenter + 1 < len[i]) {
                maxRight = i + len[i] - 1;
                maxCenter = i;
                oriLen = len[i] - 1;
                oriRight = (maxRight - 1) / 2;
            }
        }

        return s.substring(oriRight - oriLen + 1, oriRight + 1);
    }

    public static void main(String[] args) {
        String s = "babadab";
        String result = longestPalindrome(s);
        System.out.println(result);
        result = manacher(s);
        System.out.println(result);
    }
}
