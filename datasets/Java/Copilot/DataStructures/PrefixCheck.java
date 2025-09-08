import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
            if (current.isEndOfWord) {
                return false;
            }
        }
        if (!current.children.isEmpty()) {
            return false;
        }
        current.isEndOfWord = true;
        return true;
    }
}

public class PrefixCheck {
    public static void noPrefix(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            if (!trie.insert(word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
        }
        System.out.println("GOOD SET");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of words: ");
        int n = scanner.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }
        noPrefix(words);
    }
}
