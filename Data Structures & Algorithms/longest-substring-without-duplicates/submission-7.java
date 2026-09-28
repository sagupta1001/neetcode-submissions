class Solution {

    // problem
    // given a string s, find the length of the longest
    // substring without duplicate characters

    // approach
    // two pointers
    // left init to 0
    // right init to -1
    // seen chars empty set
    // global max = 0
    // curr max = 0

    // loop
    // - increment right
    // - if right char is not seen chars 
    // - - add to seen chars set
    // - - cur max = left-right+1
    // - - 
    // - else right char is in seen chars
    // - - global max = max of current max and global max
    // - - until left matches right char
    // - - - remove char from the seen chars
    // - - - increment left
    // - - curr Max = 0

    // return global max

    public int lengthOfLongestSubstring(String s) {
        int sLength = s.length();
        int left = 0, right = -1;
        HashSet<Character> seenChars = new HashSet<>();
        int globalMax = 0, currMax = 0;

        while (left != sLength) {
            if (right == sLength - 1) break;
            right++;
            Character rightChar = s.charAt(right);
            if (!seenChars.contains(rightChar)) {
                // System.out.println("not seen");
                seenChars.add(rightChar);
                // System.out.println("right=" + right + "left=" + left);
                currMax = right-left+1;
                // System.out.println(currMax);
                // System.out.println("------");
            } else {
                // System.out.println("seen");
                globalMax = Math.max(currMax, globalMax);
                char leftChar = s.charAt(left);
                while (seenChars.contains(rightChar)) { 
                    seenChars.remove(s.charAt(left)); 
                    left++; 
                } 
                seenChars.add(rightChar); 
                currMax = right - left + 1;
            }
        }

        return Math.max(currMax, globalMax);
    }
}
