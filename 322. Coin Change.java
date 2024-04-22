You are given an integer array coins representing coins of different denominations and an
integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104


class Solution {
    public int coinChange(int[] coins, int amount) {


        int dp[][] = new int[coins.length][amount+1];
        // row as coins and col as 0 to amount
        // if amount to be formed = 0
        // then the we cannot add any coins 
        // so make first col as 0


    // now we play include and exclude
    // take min of exclude and include
    // exclude is from previous row and same col
    // include is 1 + dp[i][j-coins[i]]; 
    // here 1 is that we are telling that we are including that particular coin
        for(int i = 0; i < coins.length; i++){
            dp[i][0] = 0;
            for(int j = 1; j <= amount; j++){
                // if i == 0 and coins[i] > j
                // i.e amount is less than the coin
                // give random high value

                if(i == 0 && coins[i] > j)
                dp[i][j] = 100000;
                
            // in first row we cannot see any previous value
            // only we can able to include
            else if(i == 0 && coins[i] <= j)
            dp[i][j] = 1 +  dp[i][j-coins[i]];

            // if i != 0 and if particular coin is greater than the amount
            // only consider the exclude value

            else if(coins[i] > j)
            dp[i][j] = dp[i-1][j];

            // else take min of include and exclude
            else
            dp[i][j] = Math.min(1 + dp[i][j-coins[i]], dp[i-1][j]);
            }
        }

        return dp[coins.length-1][amount] > 1e4 ? -1 : dp[coins.length-1][amount];

    
        
    }
}

