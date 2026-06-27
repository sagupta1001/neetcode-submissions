class Solution {

    // Problem: 
    // minimum number of coins needed to make up the exact target amount
    // Input: coins = [1,5,10], amount = 12
    // Output: 3

    // Approach:
    // Recursion but could be memoized
    // Target 12
    // Pick 1, Target 11, [1, 5, 10], currentNumberOfCoins = 0
    // Pick 1, Target 10, [], currentNumberOfCoins = 1
    // ...
    // Pick 1, Target 0, [1,5, 10], currentNumberOfCoins = 12

    // Pick 1, Target 10, [], currentNumberOfCoins = 1
    // Pick 5, Target 5, currentNumberOfCoins = 2
    // Pick 5, Target 0, c = 3

    // Pick 1, Target 10, [], currentNumberOfCoins = 1
    // Pick 5, Target 5, currentNumberOfCoins = 2
    // Pick 10, Target -5, c = 0

    // we just minimum number of coins


    // Pseudo code:
    // mininum number of coins to make amount 0 is zero
    // f(0) = 0
    // where f is a function where the input is the amount target
    // f(1) = f(0) + 1

    // f(x) = min over all 'c' (f(x-c) + 1)
    // where x - c >= 0 
    // So for e.g. if we want f(1) = f(1-1) + 1 is 1
    // f(1-5) is invalid f(1-10) is invalid. 
    // then f(2) = f(2-1) + 1 
    // f(5) = f(0) + 1 = 1
    // f(6) = 1 
    // f(10) = 1 
    // f(12) = 3

    public int coinChange(int[] coins, int amount) {
        int[] minNumOfCoins = new int[amount+1];
        Arrays.fill(minNumOfCoins, amount+1);
        minNumOfCoins[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    minNumOfCoins[i] = Math.min(minNumOfCoins[i], minNumOfCoins[i-coin] + 1);
                }
            }
        }

        return minNumOfCoins[amount] > amount ? -1 : minNumOfCoins[amount];
    }
}
