class WordDictionary {

    // Problem:
    // add word and search for word data structure 
    // add word adds to data structure
    // search word returns true if word exists in DS
    // query should support . where dot can be 
    // matched with any letter

    // Approach:
    // Trie
    // When we add a word
    // iterate through each character in the word
    // and add it to trie
    // When we search for word
    // iterate through each character and the trie
    // to see if there is a match
    // search - edge case
    // we have "day", "bak" in the DS
    // search for ".ay"
    // here we need to explore each character at that level
    // via recursion, and the recursive function will return
    // if a match is found so we do not need to explore other
    // paths
    // so that we check both "day" and "bak"
    // we should backtrack if a particular path does not have 
    // the next letter we are looking
    // at most 2 dots in the search queries means that we would
    // need to explore at most 26 * 26 paths

    // TrieNode
    // HashMap of character to TrieNode
    // isWord if this marks the end of a word


    // Pseudo code:

    class TrieNode {
        HashMap<Character, TrieNode> characters;
        boolean isWord;

        TrieNode() {
            characters = new HashMap<>();
            isWord = false;
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }
    }

    Trie dictionary;

    public WordDictionary() {
        dictionary = new Trie();
    }

    public void addWord(String word) {
        TrieNode current = dictionary.root;
        for (Character c : word.toCharArray()) {
            if (!current.characters.containsKey(c)) {
                current.characters.put(c, new TrieNode());
            }
            current = current.characters.get(c); 
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(dictionary.root, word);    
    }

    private boolean searchHelper(TrieNode current, String word) {
        int currIndex = -1;
        for (Character c : word.toCharArray()) {
            // System.out.println("character " + c);
            currIndex++;
            boolean isWildcard = c.equals('.');
            if (current != null && !current.characters.containsKey(c) && !isWildcard) {
                return false;
            }
            if (current != null && current.characters.containsKey(c) && !isWildcard) {
                current = current.characters.get(c);
                continue;
            }
            if (isWildcard) {
                if (current == null) return false;
                if (current.characters.keySet().size() == 0) return false;
                TrieNode parent = current;
                for (Character b : parent.characters.keySet()) {
                    // set something
                    // if (current == null) return false;
                    TrieNode child = parent.characters.get(b);
                    // System.out.println("wildcard " + b);
                    boolean foundMatch = searchHelper(child, word.substring(currIndex + 1, word.length()));
                    if (foundMatch) return true;
                }
                return false;
            }
        }
        // System.out.println("current " + current + current.isWord);
        if (current != null && current.isWord) {
            return true;
        }
        return false;
    }
}
