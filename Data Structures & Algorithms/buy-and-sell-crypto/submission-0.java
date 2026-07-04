class Solution {
    public int maxProfit(int[] prices) {
        int minPriceToBuyStock = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] -  minPriceToBuyStock; // 6
            maxProfit = Math.max(maxProfit, profit); // 6
            minPriceToBuyStock = Math.min(minPriceToBuyStock, prices[i]); // 1
        }

        return maxProfit;
    }
}
