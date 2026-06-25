class Solution {
    // Problem: Find all words in the board that are present on the board
    
    // Approach: 
    // For each word
    // start DFS on a cell if the first letter matches with the first letter of the word

    // That approach is time consuming because we can have 30K words

    // For each word, we should add it to a trie data structure
    // {"b" -> ["bat", "back", "backend"], "ba" -> ["bat", "back", "backend"], "bac" -> ["back", "backend"]}
    // but this is not optional because we storing the same word over and over again
    // we could store the index of the word from the input words instead
    // {"b" -> [0, 2, 3], "ba" -> [0], "bat" -> [0],..}

    // For each word
    // - iterate through the characters
    // - - create


    // i would start by checking if the current cell of the board exists
    // in the root node of the Trie. If it does, then explore the neighbours
    // and the children of the root TrieNode at the same time (synchronized). 
    // If the cell does not exist in the Trie, then move to the next cell on the board.
    // When we do find that the cell exists in the Trie, we check if that TrieNode is endOfWord,
    // if yes then we need the word itself. We could rely on the TrieNode to get the word back 
    // and add to the output list. 

    // Pseudo Code: 
    // Add words to Trie
    // class TrieNode {
    //  - HashMap<character, TrieNode>
    //  - boolean isEndOfWord
    //  - string word
    // }
    // class Trie {
    //  - TrieNode root
    // }

    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEndOfWord;
        String word;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
            word = null;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWords(String[] words) {
            for (String word : words) {
                TrieNode current = this.root;
                for (char c : word.toCharArray()) {
                    if (current.children.get(c) == null) {
                        current.children.put(c, new TrieNode());
                    }
                    current = current.children.get(c);
                }
                current.isEndOfWord = true;
                current.word = word;
            }
        }
    }

    // insertion of words into Trie
    // for each word in words
    //  currentNode = get Trie root
    //  for each character in the word
    //      if character exists in the current Trie node's children hashmap
    //          currentNode = currentNode.children get character
    //      else 
    //          currentNode = currentNode.children add character to TrieNode
    //  currentNode.isEndOfWord = true
    //  currentNode.word = word


    // Navigate through the board and Trie together and keep track of the words found.
    // curRow = 0
    // curCol = 0
    // class Coordinate {
    //   row
    //   col
    // }
    // Coordinate = {curRow, curCol}
    // Queue<Coordinate> traversal = new Queue<>
    // for (int r = 0; r < board.length; i++)
    //  - for (int c = 0; c < board[0].length; c++)
    //      traversal -> add coordinate (r, c)
    //      boolean [][] visited
    //      Trie current node = root
    //      while traversal not empty
    //          coordinate r, c = pop traversal
    //          mark coordinate r, c as visited
    //          check if board[r][c] exists in Trie current node character hash map
    //          if exists
    //              - get next coordinates and add them to traversal stack
    //              - update Trie current node based on the char found
    //          
    //          

    List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        trie.addWords(words);

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, trie.root, r, c);
            }
        }

        return result;
    }

    private void dfs(char[][] board, TrieNode node, int r, int c) {
        if (node == null) {
            return;
        }
        // check bounds
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '*') {
            return;
        }

        node = node.children.get(board[r][c]);
        if (node == null) {
            return;
        }
        if (node.isEndOfWord) {
            if (node.word != null)
                result.add(node.word);
            // to avoid adding duplicate words
            node.word = null;
        } 

        // mark as visited
        char prev = board[r][c];
        board[r][c] = '*';

        // traverse
        dfs(board, node, r+1, c);
        dfs(board, node, r-1, c);
        dfs(board, node, r, c+1);
        dfs(board, node, r, c-1);

        // backtrack
        // restore visited back to prev
        board[r][c] = prev;
    }
}
