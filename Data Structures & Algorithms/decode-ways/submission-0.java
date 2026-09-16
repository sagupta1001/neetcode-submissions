class Solution {
    // problem
    // number of ways to decode a string from integer back to 
    // valid alphabet characters
    // 1012
    // 10 1 2
    // 10 12
    // output is 2

    // 01
    // output is 0

    // approach
    // how to decode programatically

    // look at a character in the string 
    // convert to an integer
    // if it is between 1 and 9 then it is valid a alphabet
    // so we keep that and explore this and the rest
    // but also this character could be part of another 
    // if the next is less than 6 and current is less than 3

    // how to handle something like 01 or 30
    // if current character is 0 and not part of ..

    // we can look in groups of 1 and 2
    // 01 is invalid in both
    // 30 is invalid in both
    // 1012

    // group of 1
    // group of 2

    // 
    // pseudo code
    // 
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i+1];
                if (i+1 < n) {
                    int num = Integer.parseInt(s.substring(i, i+2));
                    if (num >= 10 && num <= 26) {
                        dp[i] += dp[i+2];
                    }
                }
            }
        }
        return dp[0];
    }
}
