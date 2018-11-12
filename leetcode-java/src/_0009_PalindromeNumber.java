/**
 * Created by goto456 on 2018/11/12.
 */
public class _0009_PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }

        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return x == reverse || x == reverse / 10;
    }

    public static void main(String[] args) {
        int x1 = 121;
        System.out.println(isPalindrome(x1));

        int x2 = -121;
        System.out.println(isPalindrome(x2));

        int x3 = 10;
        System.out.println(isPalindrome(x3));
    }
}
