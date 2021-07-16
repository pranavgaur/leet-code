class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        Arrays.sort(coins);
        dp[0] = 0;
        for(int i = 0; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i)
                    dp[i] = Math.min(dp[i], 1+dp[i - coins[j]]);
                else
                    break;
            }
        }
        
        if(dp[amount] > amount)
            return -1;
        return dp[amount];
        
    }
}