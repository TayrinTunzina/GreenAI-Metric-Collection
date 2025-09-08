import java.io.*;
import java.util.*;

public class PrefixCheck {

    public static void noPrefix(String[] words) {
        TrieNode root = new TrieNode();
        boolean isGoodSet = true;
        String badWord = "";

        for (String word : words) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);
                if (current.isEnd) {
                    isGoodSet = false;
                    badWord = word;
                    break; // Exit the loop immediately if a prefix is found
                }
            }
            if (!isGoodSet) {
                break; // Exit the outer loop if a bad word is found
            }
            current.isEnd = true;
        }

        if (isGoodSet) {
            System.out.println("GOOD SET");
        } else {
            System.out.println("BAD SET");
            System.out.println(badWord);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;

        TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }
        noPrefix(words);
    }
}
