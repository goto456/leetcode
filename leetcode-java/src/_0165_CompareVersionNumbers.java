/**
 * Created by goto456 on 2020/5/30.
 */
public class _0165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        // 注意：“.”在正则表达式有特殊含义，需要转义
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0, j = 0; i < v1.length || j < v2.length; i++, j++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = j < v2.length ? Integer.parseInt(v2[j]) : 0;
            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}
