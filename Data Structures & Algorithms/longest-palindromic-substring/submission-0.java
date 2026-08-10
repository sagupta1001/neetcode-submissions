class Solution {
    // problem
    // return the longest palindromic substring

    // approach
    // brute force
    // check each substring for a palindrome
    // keep track of the longest one so far
    // return the string
    // this would be O(N^2) to generate all substrings
    // and then O(N) to check for palindrom so 
    // O(N^3) total

    // now to optimize
    // what is a substring
    // i from 0 to N
    // j from i to N
    // get substr from i to j

    // maybe we start with a palindrome
    // a single char is a palindrome (odd size)
    // two chars can be a palindrom (even size)
    
    // two pointers, with left = 0, right = N 
    // won't work here for this problem because
    // it won't allow to explore all substrings
    
    // this seems like a recursive solution problem
    // with a dfs type traversal

    // if string is of even size then the center is of size 2,
    // and if the string is of size odd then center is of size 1

    // expand(i, i)     // odd
    // expand(i, i + 1) // even

    // pseudo code
    // center is of size 1 for odd and size 2 for even
    // for each center
    // expand(i, i)     // odd
    // expand(i, i + 1) // even
    // decrement left, increment right until left and right char are equal
    // and for center of size 2, ensure that both chars are equal
    // keep track of longest length and left / right during iteration

    // return longest length and substring via left / right

    private int[] expand(int left, int right, String s) {
        int strLength = s.length();
        if (left < 0 || right >= strLength) {
            return new int[]{left+1, right-left-1};
        }

        if (s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            return expand(left, right, s);
        } else {
            return new int[]{left+1, right-left-1};
        }
    }

    public String longestPalindrome(String s) {
        int strLength = s.length();
        int maxLength = 0;
        int left = -1;

        for (int i = 0; i < strLength; i++) {
            int[] resOdd = expand(i, i, s);
            int[] resEven = expand(i, i+1, s);

            if (resOdd[1] > maxLength) {
                maxLength = resOdd[1];
                left = resOdd[0];
            }
            if (resEven[1] > maxLength) {
                maxLength = resEven[1];
                left = resEven[0];
            }
        }

        return s.substring(left, left+maxLength);
    }
}
