/**
 * 画出曲线图，则很好理解
 * Created by goto456 on 2020/7/23.
 */
public class _0122_BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
