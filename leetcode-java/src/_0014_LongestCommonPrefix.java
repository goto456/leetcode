/**
 * Created by goto456 on 2018/11/17.
 */
public class _0014_LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String curPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(curPrefix) != 0) {
                curPrefix = curPrefix.substring(0, curPrefix.length() - 1);
                if (curPrefix.isEmpty()) {
                    return "";
                }
            }
        }
        return curPrefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
