/**
 * 二分查找解此题
 * Created by goto456 on 2020/7/2.
 */
public class _0378_KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];
        while (min < max) {
            int mid = min + ((max - min) >> 1);
            if (check(matrix, k, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    /**
     * 判断左上角部分数目是否大于等于k个
     */
    private boolean check(int[][] matrix, int k, int mid) {
        int n = matrix.length;
        // 从左下角开始计数
        int col = 0;
        int row = n - 1;
        int count = 0;
        while (col < n && row >= 0) {
            if (matrix[row][col] <= mid) {
                col++;
                count += row + 1;
            } else {
                row--;
            }
        }
        return count >= k;
    }
}
