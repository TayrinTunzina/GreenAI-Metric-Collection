import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
        children = new HashMap<>();
        isEnd = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
            if (node.isEnd) return false; // Existing prefix found
        }
        if (!node.children.isEmpty()) return false; // Current word is a prefix
        node.isEnd = true;
        return true;
    }
}

public class PrefixCheck {
    public static void noPrefix(List<String> words) {
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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline
        List<String> words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            words.add(sc.nextLine());
        }

        noPrefix(words);
        sc.close();
    }
}
