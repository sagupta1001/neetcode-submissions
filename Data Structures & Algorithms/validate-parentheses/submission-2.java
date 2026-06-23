class Solution {

    private boolean isOpenBracket(Character c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isCloseBracket(Character c) {
        return c == ')' || c == ']' || c == '}';
    }

    private boolean isBracketNotMatch(Character c, Character o) {
        if (c == ')' && o == '(') return true;
        if (c == '}' && o == '{') return true;
        if (c == ']' && o == '[') return true;
        return false;
    }

    public boolean isValid(String s) {
        // if close bracket and stack empty then return false

        // if open bracket then add to stack

        // if close bracket then check top of stack / pop

        Deque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (isCloseBracket(c)) {
                Character top = stack.peek();
                if (top == null || !isBracketNotMatch(c, top)) {
                    return false;
                }
                stack.pop();
            } else if (isOpenBracket(c)) {
                stack.push(c);
            } else {
                // throw exception
            }
        }

        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
