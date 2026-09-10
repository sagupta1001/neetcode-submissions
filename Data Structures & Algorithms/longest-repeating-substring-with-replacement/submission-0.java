class Solution {
    // problem
    // given a string of uppercase english chars
    // A-Z
    // integer k
    // replace upto k chars and return the number
    // of longest substring which contains only
    // one distinct char

    // approach
    // XYYX, k=2
    // AAABABB, k=1
    // looking for the longest substring with 1 distinct 
    // char
    // AAA, BB, B, A
    // the char where it stops become a distinct long substring
    // thats the one to replace

    // AAABBCAAABCA
    // here we need to identify the second AAABCA because it 
    // would lead to length of a substring 6 vs 5 earlier

    // sliding window
    // start with left=0, right=0
    // hashmap of int[26]
    // map[curChar-'A']++; i.e. map[24] = 1
    // 

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Add current character to the window.
            int index = s.charAt(right) - 'A';
            count[index]++;

            // Highest frequency character in the window.
            maxFreq = Math.max(maxFreq, count[index]);

            // Characters we need to replace.
            int windowSize = right - left + 1;
            int replacements = windowSize - maxFreq;

            // Window is invalid, so shrink it.
            while (replacements > k) {
                count[s.charAt(left) - 'A']--;
                left++;

                windowSize = right - left + 1;
                replacements = windowSize - maxFreq;
            }

            maxLength = Math.max(maxLength, windowSize);
        }

        return maxLength;
    }
}
