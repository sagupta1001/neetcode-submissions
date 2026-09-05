class Solution {
    // problem
    // return the unique letters in the new language in sorted order
    // or "" if the dictionary is not valid
    // sort = a < b, or a is a prefix of b and a.length < b.length


    // for a single character words like "z", "o"
    // the dictionary would be valid and a unique set of those characters

    // now for multi character words
    // lets look at the first character of each word
    // her
    // if we look at two adjacent words
    // hrn and hrf
    // h, r and then between n and f we don't know comes first yet
    // actually n < f
    // then hrf and er
    // h < e, 
    // r < n
    // e < r

    public String foreignDictionary(String[] words) {
        Set<Character> chars = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                chars.add(c);
            }
        }

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (char c : chars) {
            graph.put(c, new HashSet<>());
            indegree.put(c, 0);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i + 1];

            int len = Math.min(a.length(), b.length());
            int j = 0;

            while (j < len && a.charAt(j) == b.charAt(j)) {
                j++;
            }

            // Invalid prefix case: "abc" comes before "ab"
            if (j == len) {
                if (a.length() > b.length()) {
                    return "";
                }
                continue;
            }

            char from = a.charAt(j);
            char to = b.charAt(j);

            // Avoid duplicate edges
            if (!graph.get(from).contains(to)) {
                graph.get(from).add(to);
                indegree.put(to, indegree.get(to) + 1);
            }
        }

        // 3. Start with characters having no prerequisites
        Queue<Character> queue = new LinkedList<>();

        for (char c : chars) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        // 4. Topological sort
        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            for (char next : graph.get(current)) {
                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        // 5. If we couldn't process every character, there's a cycle
        if (result.length() != chars.size()) {
            return "";
        }

        return result.toString();
    }
}
