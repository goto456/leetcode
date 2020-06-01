import java.util.ArrayList;
import java.util.List;

/**
 * @author goto456
 */
public class _1431_KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCount = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > maxCount) {
                maxCount = candies[i];
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= maxCount);
        }
        return result;
    }

}
