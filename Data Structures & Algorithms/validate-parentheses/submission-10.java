// problem
// given a string consisting of '(', ')'..

// string is valid only if 
// every open bracket is closed by the same
// open bracket is closed in the correct order
// every close has a corresponding open of the same type

// examples
// []
// ([{}])

// approach
// stack
// lifo

// keep pushing the open bracket characters to stack
// if we see a close bracket then check the top of the stack
// if the top is a match to the close then pop it
// if the top is not a match then return false

class Solution {
    private boolean isCloseParentheses(char c) {
        if (c == ']' || c == '}' || c == ')') return true;
        return false;
    }

    private boolean isOpenParentheses(char c) {
        if (c == '[' || c == '{' || c == '(') return true;
        return false;
    }

    private boolean isMatchingParentheses(char open, char close) {
        if ((open == '[' && close == ']') ||
            (open == '{' && close == '}') ||
            (open == '(' && close == ')'))
            return true;
        return false;
    }

    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<>();

        for (char c : s.toCharArray()) {
            if (isCloseParentheses(c)) {
                Character closeParentheses = c;
                if (parentheses.size() == 0) return false;
                Character lastParentheses = parentheses.pop();
                if (!isOpenParentheses(lastParentheses) || !isMatchingParentheses(lastParentheses, closeParentheses)) return false;
            } else {
                parentheses.push(c);
            }
        }

        return parentheses.size() == 0;
    }
}
