import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    int count;
    
    public TrieNode() {
        children = new HashMap<>();
        count = 0;
    }
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void add(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            node.count++;
        }
    }
    
    public int find(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return 0;
            }
            node = node.children.get(c);
        }
        return node.count;
    }
}

public class ContactsApp {
    
    public static List<Integer> contacts(List<String> queries) {
        Trie trie = new Trie();
        List<Integer> results = new ArrayList<>();
        
        for (String query : queries) {
            String[] parts = query.trim().split(" ", 2);
            String operation = parts[0];
            
            if (operation.equals("add")) {
                String name = parts[1];
                trie.add(name);
            } else if (operation.equals("find")) {
                String partial = parts[1];
                int count = trie.find(partial);
                results.add(count);
            }
        }
        
        return results;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of operations: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Clear newline
        
        List<String> queries = new ArrayList<>();
        System.out.println("Enter " + n + " operations:");
        System.out.println("Format: 'add name' or 'find partial'");
        
        for (int i = 0; i < n; i++) {
            queries.add(scanner.nextLine());
        }
        
        List<Integer> results = contacts(queries);
        
        System.out.println("\nResults for find operations:");
        for (Integer result : results) {
            System.out.println(result);
        }
        
        scanner.close();
    }
}
