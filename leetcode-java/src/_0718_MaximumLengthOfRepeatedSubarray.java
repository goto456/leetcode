/**
 *  滑动窗口解此题
 * Created by goto456 on 2020/7/1.
 */
public class _0718_MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int maxLength = 0;
        int n = A.length;
        int m = B.length;

        // A不动，B滑动
        for (int i = 0; i < n; i++) {
            int len = Math.min(n - i, m);
            int curLength = maxLength(A, B, i, 0, len);
            maxLength = Math.max(maxLength, curLength);
        }

        // B不动，A滑动
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int curLength = maxLength(A, B, 0, i, len);
            maxLength = Math.max(maxLength, curLength);
        }

        return maxLength;
    }

    /**
     * 求对齐之后最长公共子序列长度
     */
    private int maxLength(int[] A, int[] B, int startA, int startB, int len) {
        int maxLength = 0;
        int curLength = 0;
        for (int i = 0; i < len; i++) {
            if (A[startA + i] == B[startB + i]) {
                curLength++;
            } else {
                curLength = 0;
            }
            maxLength = Math.max(maxLength, curLength);
        }
        return maxLength;
    }
}
