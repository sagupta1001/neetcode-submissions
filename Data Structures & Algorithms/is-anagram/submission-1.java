class Solution {
    // Sep 28
    // problem 
    // given two strings s and t, return true if the two strings
    // are anagrams of each other
    // should contain the same characters, with the same frequency
    // order does not matter
    
    // approach
    // hash map with the key being the character, and value being the
    // frequency
    // build it for s
    // then as we iterate through t, decrement the key value if it exists
    // remove key from hash map if it is zero
    // at the end the hash map should be empty then its a valid anagram


    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        if (sLength != tLength) return false;

        HashMap<Character, Integer> anagramMap = new HashMap<>();

        for (char sChar : s.toCharArray()) {
            anagramMap.put(sChar, anagramMap.getOrDefault(sChar, 0) + 1);
        }

        for (char tChar : t.toCharArray()) {
            if (!anagramMap.containsKey(tChar)) return false;
            
            anagramMap.put(tChar, anagramMap.get(tChar) - 1);
            if (anagramMap.get(tChar) == 0) anagramMap.remove(tChar);
        }

        return anagramMap.size() == 0;
    }
}
