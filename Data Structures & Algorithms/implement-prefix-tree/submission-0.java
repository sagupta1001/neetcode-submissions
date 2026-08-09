class PrefixTree {
    // problem
    //   d 
    //   o
    //   g
    
    // approach
    // node has a hashmap of trienode to trienode?
    // lowercase english letters only
    // so we could use a fixed size array of 26 

    // tree has a root
    // root is a trienode
    // trienode needs to know if the end of a word
    // trienode needs to have a map, character to TrieNode
    // actually we'll just a TrieNode array of size 26 at each level 
    // instead of the map





    // startsWith
    // get root of trie
    // current trie node = root
    // for each character in the word
    // - get index in trie node for charcter
    // - if character not in current trie node's charecters
    // - - return false
    // - current = current.characters[index]

    // return true

    class TrieNode {
        TrieNode[] characters;
        boolean isWord;

        TrieNode() {
            characters = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        // insert
        // get root of Trie
        TrieNode current = root;
        // current trie node = root
        // for each character in the word
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.characters[index] == null) {
                current.characters[index] = new TrieNode();
            }
            current = current.characters[index];
        }
        current.isWord = true;
        // - get index in trie node for character
        // - - 'd' - 'a' -> 3
        // - if character not in current trie node's characters
        // - - characters[index] = new TrieNode()
        // - current = current.characters[index]
        // current.isWord = true
        
        return;
    }

    public boolean search(String word) {
        // search
        // get root of trie
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.characters[index] == null) return false;
            current = current.characters[index];
        }

        // current trie node = root
        // for each character in the word
        // - get index in trie node for charcter
        // - if character not in current trie node's charecters
        // - - return false
        // - current = current.characters[index]
        // return current.isWord == true
        return current.isWord == true;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.characters[index] == null) return false;
            current = current.characters[index];
        }
        return true;
    }
}
