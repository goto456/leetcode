/**
 * 递归求解
 * Created by goto456 on 2020/4/20.
 */
public class _0038_CountAndSay {
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String preStr = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int preIndex = 0;
        for (int i = 1; i < preStr.length(); i++) {
            if (preStr.charAt(i) != preStr.charAt(preIndex)) {
                int count = i - preIndex;
                sb.append(count).append(preStr.charAt(preIndex));
                preIndex = i;
            }
        }
        sb.append(preStr.length() - preIndex).append(preStr.charAt(preIndex));
        return sb.toString();
    }
}
