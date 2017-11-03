import java.util.HashMap;
import java.util.Map;

/**
 * FileName: LongestSubstringWithoutRepeatingCharacters_3.java
 * Description:
 * Authors: wangbiwen
 * Date: 17-11-3
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static int lengthOfLongestSubstring(String s) {
        // 用于记录字符到下标的映射，重复字符记录最大的下标
        Map<Character, Integer> itemToIndexMap = new HashMap<>();
        int maxLen = 0;
        // 用于记录当前无重复字符串的最左下标
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!itemToIndexMap.containsKey(ch) || itemToIndexMap.get(ch) < left) {
                itemToIndexMap.put(ch, i);
                continue;
            }

            // 更新最大长度值
            maxLen = Math.max(maxLen, i - left);
            // 更新最左下标
            left = Math.max(left, itemToIndexMap.get(ch) + 1);
            // 更新重复字符的下标
            itemToIndexMap.put(ch, i);
        }

        maxLen = Math.max(maxLen, s.length()  - left);
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
