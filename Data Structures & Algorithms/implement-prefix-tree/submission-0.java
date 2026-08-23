class PrefixTree {
    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            // word = dog, index = 'd' - 'a' = 3, current = root
            // word = dog, index = 'o' - 'a', current = ^
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] != null) {
                current = current.children[index];
            } else {
                return false;
            }
        }

        return (current.isEndOfWord == true) ? true : false;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] != null) {
                current = current.children[index];
            } else {
                return false;
            }
        }
        return true;
    }
}
