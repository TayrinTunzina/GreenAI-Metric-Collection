import java.util.*;

public class PrefixCheck {
    
    // Trie node class to efficiently check for prefixes
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        
        TrieNode() {
            children = new TrieNode[10]; // 'a' to 'j' (10 letters)
            isEndOfWord = false;
        }
    }
    
    // Function to insert a string into the Trie and check if it's a prefix or has a prefix
    static boolean insertAndCheck(TrieNode root, String word) {
        TrieNode node = root;
        
        // Check if this word is a prefix of an existing word
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            
            node = node.children[index];
            
            // If we reach an end of word marker before finishing our word,
            // then some existing word is a prefix of the current word
            if (node.isEndOfWord) {
                return true;
            }
        }
        
        // Check if the current word is a prefix of an existing word
        // If the node already has any children, then current word is a prefix of some other word
        for (int i = 0; i < 10; i++) {
            if (node.children[i] != null) {
                return true;
            }
        }
        
        // Mark the end of word
        node.isEndOfWord = true;
        return false;
    }
    
    public static void noPrefix(List<String> words) {
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            if (insertAndCheck(root, word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
        }
        
        System.out.println("GOOD SET");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }
        
        noPrefix(words);
        scanner.close();
    }
}