class Solution {
    // problem
    // return number of substrings that are palindromes


    // approach
    // generate all substrings
    // for each substring check if palindrome
    // total runtime would be O(N^2) * O(N) = O(N^3)
    // this is brute force

    // we could cache the result of whether a substring is a 
    // palindrome, so worst cast would still be N^3
    // but on average as there may be idential substrings
    // that are palindromes, it would be closer to 
    // N^2.5

    // 

    private int expand(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }

    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i); // odd

            count += expand(s, i, i+1); // even
        }

        return count;
    }
}
