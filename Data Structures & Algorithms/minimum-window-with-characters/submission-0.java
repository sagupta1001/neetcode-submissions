class Solution {
    // problem
    // minimum window substring
    // two strings, s and t
    // return the shortest substring of s
    // such that every character in t, 
    // return "" is no substring in s

    // approach
    // generate all substrings for "s"
    // and check each string if it contains 
    // all "t" characters
    // this would be S^2*T in runtime 

    // how to optimize?
    // ouzodyxazv 
    // xyz

    // left = 0, right = 0
    // o -> 2, u -> 1, z -> 2, d -> 1, y -> 1, x -> 1, v -> 1
    // x -> 1, y -> 1, z -> 1

    // initailly i could keep 
    // shifting left until the two maps are valid and sMap is a superset of t map
    // then when shifting left is not possible i.e when we reach the "Y", then keep 
    // shifting right back

    // actually expand right until s's substring has all of t
    // then shrink it down using left
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        // Frequency required for each character in t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int required = tMap.size();
        int formed = 0;

        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // This character now satisfies its required frequency
            if (tMap.containsKey(c)
                    && window.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }

            // Current window contains everything required
            while (formed == required) {
                int currentLength = right - left + 1;

                if (currentLength < minLength) {
                    minLength = currentLength;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // Removing this character made the window invalid
                if (tMap.containsKey(leftChar)
                        && window.get(leftChar) < tMap.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(minLeft, minLeft + minLength);
    }
}
