import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法解ip地址还原问题
 * Created by goto456 on 2020/5/3.
 */
public class _0093_RestoreIpAddresses {
    private List<String> result = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }

        LinkedList<String> track = new LinkedList<>();
        backtrack(s, 0, 0, track);
        return result;
    }

    private void backtrack(String s, int splitTime, int start, LinkedList<String> track) {
        if (start == s.length() && splitTime == 4) {
            result.add(String.join(".", track));
            return;
        }

        // 剪枝，剩下的不符合分割条件
        if ((s.length() - start) < (4 - splitTime) || (s.length() - start) > 3 * (4 - splitTime)) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            // 结束条件
            if (start + i >= s.length()) {
                break;
            }

            String ipSegment = getIpSegment(s, start, start + i);
            if (ipSegment.equals("")) {
                continue;
            }
            track.add(ipSegment);
            backtrack(s, splitTime + 1, start + i + 1, track);
            track.removeLast();
        }
    }

    /**
     * 获取各个分段
     */
    private String getIpSegment(String s, int left, int right) {
        // 2位及以上时，首位不能为0
        if (right - left > 0 && s.charAt(left) == '0') {
            return "";
        }
        int segment = 0;
        for (int i = left; i <= right; i++) {
            segment = segment * 10 + (s.charAt(i) - '0');
        }

        if (segment > 255) {
            return "";
        }
        return String.valueOf(segment);
    }
}
