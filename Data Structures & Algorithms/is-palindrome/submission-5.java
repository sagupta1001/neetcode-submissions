// problem
// given a string return true if it is a palindrome
// case insensitive and ignore non-alphanumeric chars

// a-z,A-Z and 0-9

// approach
// compare the first and last characters
// if not equal then return false
// keep comparing the next two characters (increment first and
// decrement last)
// before comparing make sure they are alphanumeric, if not 
// then skip them
class Solution {

    private boolean isAlphanumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    public boolean isPalindrome(String s) {
        int sLength = s.length();
        int frontIndex = 0, backIndex = sLength - 1;

        while (frontIndex < backIndex) {
            while (frontIndex < sLength-1 && !isAlphanumeric(s.charAt(frontIndex))) frontIndex++;
            while (backIndex > 0 && !isAlphanumeric(s.charAt(backIndex))) backIndex--;

            if (frontIndex >= backIndex) return true;
            char frontChar = Character.toLowerCase(s.charAt(frontIndex));
            char backChar = Character.toLowerCase(s.charAt(backIndex));

            if (frontChar != backChar) return false;
            frontIndex++;
            backIndex--;
        }
        return true;
    }
}
