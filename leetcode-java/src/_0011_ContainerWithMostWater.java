/**
 * Created by goto456 on 2018/11/14.
 */
public class _0011_ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int curArea = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(maxArea, curArea);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
