/**
 * FileName: RverseString_344.java
 * Description: 思路很简单，见代码
 * Authors: wangbiwen
 * Date: 17-1-23
 */
public class _0344_ReverseString {
    public String reverseString(String s) {
        int length = s.length();
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = s.charAt(length - 1 - i);
        }
        return String.valueOf(chars);
    }

    public String reverseString2(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        _0344_ReverseString reverse = new _0344_ReverseString();
        String s = "hello";
        String result = reverse.reverseString(s);
        System.out.println(result);
    }
}
