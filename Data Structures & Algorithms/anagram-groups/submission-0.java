class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // for each word create a hash map
        // "act" -> { a: 1, c: 1, t: 1}
        // "pots" -> ..
        // "cat" -> { c: 1, a: 1, t: 1}
        // Hash Map from index to the word hash map
        // { 0: { a: 1, c: 1, t: 1} }
        // ..

        // for each entry in the Hash Map
        // missing part was the key has to be the hash map compacted
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            for (Character c : s.toCharArray()) {
                count[c - 'a'] += 1;
            }

            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }

        return new ArrayList<>(res.values());
    }
}
