class Solution {
    // problem
    // generate well-formed parentheses strings with n pairs

    // approach
    // generate pairs of parenthesis and then check if its valid
    
    // or use recursion 
    // have a function 
    // that takes current N, 

    // if N = 1
    // leftUsed = 0
    // numOpen = -1
    
    // if leftUsed == N and numOpen == 0
    // - exit the traversal

    // add left to current and continue traversal, increment leftUsed, increment numOpen
    // if numOpen > 0, addRight and continue traversal, decrement numOpen
    

    private List<String> res;

    private void dfs(int n, int leftUsed, int numOpen, StringBuilder currString) {
        if (leftUsed == n && numOpen == 0) {
            res.add(currString.toString());
            return;
        }

        if (leftUsed < n) {
            currString.append("(");
            dfs(n, leftUsed + 1, numOpen + 1, currString);
            currString.deleteCharAt(currString.length() - 1);
        }

        if (numOpen > 0) {
            currString.append(")");
            dfs(n, leftUsed, numOpen - 1, currString);
            currString.deleteCharAt(currString.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder());
        return res;
    }
}
