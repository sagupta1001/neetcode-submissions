class Solution {
    public boolean isPalindrome(String s) {
        // initialize two pointers at the start and end of the string
        int start = 0;
        int end = s.length() - 1;

        // 1. Find two valid chars to compare
        while (start <= end) {
            // compare the two characters only if they are both alphanumberic
            char startCh = s.charAt(start);
            char endCh = s.charAt(end);

            if (!Character.isLetterOrDigit(startCh)) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(endCh)) {
                end--;
                continue;
            }

            // check the start char and end char
            if (Character.toLowerCase(startCh) != Character.toLowerCase(endCh)) {
                return false;
            }

            // if they are both alphanumeric - then compare them 
            // ignore case
            // if they do not match then return false
            // if they do match then find next two chars to compare
            start++;
            end--;
        }
     
        // at the end of loop return true 
        return true;
    }
}
