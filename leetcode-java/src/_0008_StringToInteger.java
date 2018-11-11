/**
 * Created by goto456 on 2018/11/11.
 */
public class _0008_StringToInteger {
    public static int myAtoi(String str) {
        str = str.trim();

        if (str == null || str.length() < 1) {
            return 0;
        }

        int i = 0;

        // 判断正负号
        char flag = '+';
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        // 用double存储防止越界
        double result = 0;

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-') {
            result = -result;
        }

        // 判断是否越界
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        String s1 = "42";
        System.out.println(myAtoi(s1));

        String s2 = "   -42";
        System.out.println(myAtoi(s2));

        String s3 = "4193 with words";
        System.out.println(myAtoi(s3));

        String s4 = "words and 987";
        System.out.println(myAtoi(s4));

        String s5 = "-91283472332";
        System.out.println(myAtoi(s5));
    }
}
