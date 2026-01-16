class Solution {
    public int maxProfit(int[] prices) {
        // left array to store low value
        int left = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            // calculate +ve and find max value/ profit
            if(prices[i] - left > 0) {
                max = Math.max(max, prices[i] - left);
            }
            if(left >  prices[i]) left = prices[i];
        }
        return max;
    }
}
