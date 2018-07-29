/**
 * Created by goto456 on 29/07/2018.
 *
 */
public class _0007_ReverseIntege {
    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int pop = x % 10;
            result = result * 10 + pop;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
        x = 1534236469;
        System.out.println(reverse(x));
    }
}
