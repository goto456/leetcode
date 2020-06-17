/**
 * Created by goto456 on 2020/6/17.
 */
public class _1014_BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        // 公式做如下拆分，将O(n^2)复杂度降为O(n)复杂度
        // A[i] + A[j] + i - j = (A[i] + i) + (A[j] - j) = mx + (A[j] - j)
        int result = 0;
        int mx = A[0] + 0;
        for (int j = 1; j < A.length; j++) {
            result = Math.max(result, mx + A[j] - j);
            mx = Math.max(mx, A[j] + j);
        }
        return result;
    }
}
