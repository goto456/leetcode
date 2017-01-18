/**
 * FileName: MaxConsecutiveOnes_485.java
 * Description: 思路很简单，见代码
 * Authors: wangbiwen
 * Date: 17-1-18
 */
public class MaxConsecutiveOnes_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int curCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curCount++;
            } else {
                maxCount = curCount > maxCount ? curCount : maxCount;
                curCount = 0;
            }
        }
        return curCount > maxCount ? curCount : maxCount;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes_485 mco = new MaxConsecutiveOnes_485();
        int[] nums = {1, 1, 0, 1, 1, 1};
        int result = mco.findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }
}
