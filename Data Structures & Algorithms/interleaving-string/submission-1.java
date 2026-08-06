class Solution {
    // problem
    // s1, s2 and s3
    // return true if s3 is formed by interleaving s1 and s2 
    // together 
    // n and m substrings of s and t should be within 1 count
    // of each other
    // s1 + t1 .. or t1 + s1

    // approach
    // brute force
    // if all three are empty strings
    // then true
    // if s1 is "a", s2 is "" and s3 is "a"
    // then true
    // and vice versa is true too
    // if s1 is "a", s2 = "" and s3 = "b"
    // then false and vice versa too
    // if s1 is "a" and s2 = "b" and s3 = "b"
    // then pick s2 substring and increment s2 index
    // vice versa pick s1 substring and increment s1 index
    // if s1 is "a" and s2 = "b" and s3 = "c"
    // then false
    // when we pick s1 or s2 substring at every index, keep track 
    // of how many substrings picked so far, we will count 
    // each character as a substring 
    // if at the end of iteration of s1 and s2 the difference 
    // between the substring lengths picked is > 1 then false

    // if s1 is "ax", s2 = "ay" and s3 = "ax"
    // then which "a" to pick?
    // ideally we explore both
    // this tells us we need a recursion based approach

    // pseudo code
    // dfs(i, j)
    // - base case is i == s1.length and j == s2.length 
    // and i + j == s3.length i.e. then return true

    // if s1 at i == s3 at i+J
    // - picks1 = dfs(i+1, j)
    // if s2 at j == s3 at i+j
    // - picks2 = dfs(i, j+1)

    // return picks1 || pickS2

    // i = 2, j = 1
    // 
    Boolean[][] memo;
    private boolean dfs(int curS1Index, int curS2Index, String s1, String s2, String s3) {
        if (curS1Index == s1.length() && curS2Index == s2.length()) {
            return true;
        }

        if (memo[curS1Index][curS2Index] != null) {
            return memo[curS1Index][curS2Index];
        }

        boolean pickS1 = false;
        boolean pickS2 = false;
        if (curS1Index < s1.length() && s1.charAt(curS1Index) == s3.charAt(curS1Index+curS2Index)) {
            pickS1 = dfs(curS1Index+1, curS2Index, s1, s2, s3);
        }
        if (curS2Index < s2.length() && s2.charAt(curS2Index) == s3.charAt(curS1Index+curS2Index)) {
            pickS2 = dfs(curS1Index, curS2Index+1, s1, s2, s3);
        }
        memo[curS1Index][curS2Index] = pickS1 || pickS2;
        return memo[curS1Index][curS2Index];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        memo = new Boolean[s1.length()+1][s2.length()+1];

        return dfs(0, 0, s1, s2, s3);
    }
}
