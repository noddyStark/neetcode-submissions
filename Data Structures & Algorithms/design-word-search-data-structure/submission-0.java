class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int position, TrieNode current) {

        if (position == word.length()) {
            return current.isEndOfWord;
        }

        char ch = word.charAt(position);

        if (ch == '.') {
            for (TrieNode child : current.children) {
                if (child != null && search(word, position + 1, child)) {
                    return true;
                }
            }

            return false;
        }

        int index = ch - 'a';

        if (current.children[index] == null) {
            return false;
        }

        return search(word, position+1, current.children[index]);
    }
}
