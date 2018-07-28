/**
 * Authors: wangbiwen
 * Date: 17-11-15
 */
public class _0004_MedianOfTwoSortedArrays {

    // 初步想法，思路类似merge两个有序数组，时间复杂度是O(m + n)，不符合要求
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int len = nums1.length + nums2.length;
        int k = len / 2;
        int prev = 0;
        int cur = 0;
        while (i < nums1.length && j < nums2.length && i + j <= k) {
            if (nums1[i] < nums2[j]) {
                prev = cur;
                cur = nums1[i];
                i++;
            } else {
                prev = cur;
                cur = nums2[j];
                j++;
            }
        }
        while (i < nums1.length && i + j <= k) {
            prev = cur;
            cur = nums1[i];
            i++;
        }
        while (j < nums2.length && i + j <= k) {
            prev = cur;
            cur = nums2[j];
            j++;
        }
        if (len % 2 == 0) {
            return (prev + cur) / 2.0;
        } else {
            return cur;
        }
    }

    // 时间复杂度O(log(m+n))
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 保证m<n, 避免j出现负数
        if (m > n) {
            int[] tempArray = nums1;
            nums1 = nums2;
            nums2 = tempArray;
            int temp = m;
            m = n;
            n = temp;
        }
        int halfLen = (m + n + 1) / 2;
        int iMin = 0;
        int iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < m && nums1[i] < nums2[j - 1]) { // i的值偏小
                iMin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) { // i的值偏大
                iMax = i - 1;
            } else { // i的值正好
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                // 如果总数是奇数，则中位数是左半部分最大的数；否则为左边最大和右边最小数的平均值
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[] {1, 3};
//        int[] nums2 = new int[] {2};
//        int[] nums1 = new int[] {1, 2};
//        int[] nums2 = new int[] {3, 4};
        int[] nums1 = new int[] {};
        int[] nums2 = new int[] {3, 4};
        double result = findMedianSortedArrays2(nums1, nums2);
        System.out.println(result);
    }
}
