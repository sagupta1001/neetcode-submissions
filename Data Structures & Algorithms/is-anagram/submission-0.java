class Solution {
    public boolean isAnagram(String s, String t) {
        // create a hash map for each string 
        // index 0 -> 'a', index 25 -> 'z'
        int[] sFreqMap = new int[26];
        int[] tFreqMap = new int[26];

        // and compare them

        for (Character c : s.toCharArray()) {
            sFreqMap[c - 'a']++;
        }
        for (Character c : t.toCharArray()) {
            tFreqMap[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sFreqMap[i] != tFreqMap[i])
                return false;
        }
        return true;
    }
}
