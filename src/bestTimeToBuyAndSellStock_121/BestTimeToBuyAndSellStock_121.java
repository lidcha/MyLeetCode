package bestTimeToBuyAndSellStock_121;

/**
 * @Description：leetcode 121,Best Time To Buy And Sell Stock
 * @createDate ：2020年3月28日
 */
public class BestTimeToBuyAndSellStock_121 {
	// 低点买入，高点卖出，只能交易一次，因此问题本质是求波峰浪谷差值的最大值
	//直接用两个for循环也能做出来，但是时间复杂度太高，第一次的代码如下：
	/*class Solution {
	    public int maxProfit(int[] prices) {
	        int profit = 0;
	        for(int i=0;i<prices.length;i++){
	            for(int j=i+1;j<prices.length;j++){
	                int tmp = prices[j]-prices[i];
	                if(tmp>profit)
	                    profit = tmp;
	            }
	        }
	        return profit;
	    }
	}*/
	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int profit = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])// 递增
				profit = Math.max(profit, prices[i] - min);
			else// 寻找低点
				min = Math.min(min, prices[i]);
		}
		return profit;
	}
}
