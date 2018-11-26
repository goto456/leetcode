/**
 * Created by goto456 on 2018/11/26.
 */
public class _0029_DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        // 用long型来存储，防止越界
        long dividendLong = dividend;
        long divisorLong = divisor;

        long dividendAbs = Math.abs(dividendLong);
        long divisorAbs = Math.abs(divisorLong);
        if (dividendAbs < divisorAbs) {
            return 0;
        }

        long tempResult = 1;
        long m = dividendAbs;
        long n = divisorAbs;
        // 通过移位找到最大的乘数，使得和 n 的乘积小于等于 m
        while ((m >> 1) >= n) {
            tempResult = tempResult << 1;
            n = n << 1;
        }

        // 递归求解
        long result = tempResult + divide((int)(m - n), (int)divisorAbs);

        // 确定最后结果的符号，及是否越界
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            return -result < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)-result;
        } else {
            return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
        }
    }

    public static void main(String[] args) {
        int dividend = 28;
        int divisor = 3;
        System.out.println(divide(dividend, divisor));

        dividend = -2147483648;
        divisor = -1;
        System.out.println(divide(dividend, divisor));
    }
}
