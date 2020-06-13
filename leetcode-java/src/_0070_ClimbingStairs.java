/**
 * Created by goto456 on 2020/6/13.
 */
public class _0070_ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }

        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
