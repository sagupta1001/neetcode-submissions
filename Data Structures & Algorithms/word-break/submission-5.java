class Solution {
    // problem
    // return true if the input string can be segmented
    // into the dictonary words
    // essentially is the input a list of valid words

    // approach
    // brute force
    // iterate letter by letter in the input word
    // and in each iteration check if the "word so far"
    // exists in the dictionary list.
    // once we find a match then reset the "word so far"
    // if all words are found then return true otherwise
    // false
    // we use a hash set to speed up dictionary lookup

    // once we find a match then reset the "word so far"
    // and also continue to look for a longer match too

    // recursion and dfs

    // pseudo code
    // initialize this traversal at index 0
    // dfs(index)
    // - if index is length of input string then return true
    // - curr segment is substring from 0 inclusive to index+1 exclusive
    // - some kind of loop to check if curr segment is in the dictionary
    // - - if not then increment index until there is a match or we end the input
    // - - string
    // - - if there is a match then we also call dfs with index+1 but continue with loop

    // return the OR response from the current dfs and the recursive dfs

    private boolean dfs(int index, String s, HashSet<String> dict, Boolean[] memo) {
        if (index == s.length()) {
            return true;
        }
        if (memo[index] != null) {
            return memo[index];
        }

        boolean canSegment = false;
        for (int i = index; i < s.length(); i++) {
            String currSegment = s.substring(index, i+1);
            // System.out.println(currSegment);
            // System.out.println(dict.contains(currSegment));
            if (!dict.contains(currSegment)) continue;
            // System.out.println(index);
            canSegment = canSegment || dfs(i+1, s, dict, memo);
            memo[index] = canSegment;
        }

        return canSegment;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()+1];
        HashSet<String> dict = new HashSet<>();
        for (String w : wordDict) {
            dict.add(w);
        }

        return dfs(0, s, dict, memo);
    }
}
