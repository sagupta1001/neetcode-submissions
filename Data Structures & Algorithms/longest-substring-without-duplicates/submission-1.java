class Solution {
    public int lengthOfLongestSubstring(String s) {
        // hash set to keep track of any duplicates
        
        // reset the substring length and hashset 
        // when we encounter a duplicate

        // counter?
        // abbcde

        // abcdc
        // keep track of the left pointer

        int leftPointer = 0;
        int rightPointer = 0;
        int currentLongestSubstringLength = 0;
        int maxLongestSubstringLength = 0;
        HashSet<Character> uniqueCharsOfSubstring = new HashSet<>();

        for (rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            Character currCh = s.charAt(rightPointer);
            // - if character does exist in the hash set
            // - do while loop start
            // -   now if character exists in the hash set
            // -   slide the left pointer and remove the left char from the hash set
            // -   decrement longest substring count
            // - loop end
            if (uniqueCharsOfSubstring.contains(currCh)) {
                maxLongestSubstringLength = Math.max(currentLongestSubstringLength, maxLongestSubstringLength);
                while (leftPointer < rightPointer) {
                    char leftCh = s.charAt(leftPointer);
                    leftPointer++;
                    currentLongestSubstringLength--;
                    uniqueCharsOfSubstring.remove(leftCh);
                    if (leftCh == currCh) {
                        break;
                    }
                }
            }


            // add the rightPointer character to a hash set
            uniqueCharsOfSubstring.add(s.charAt(rightPointer));
            // increment longest substring count by checking with current longest substring
            currentLongestSubstringLength++;
            // iterate to next characters
            
        }

        return Math.max(maxLongestSubstringLength, currentLongestSubstringLength);

    }
}
