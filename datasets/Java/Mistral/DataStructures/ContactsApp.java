import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0;
}

class Contacts {
    private TrieNode root;

    public Contacts() {
        root = new TrieNode();
    }

    public void add(String name) {
        TrieNode node = root;
        for (char c : name.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.count++;
        }
    }

    public int find(String partial) {
        TrieNode node = root;
        for (char c : partial.toCharArray()) {
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
        Contacts contactsApp = new Contacts();
        List<Integer> results = new ArrayList<>();
        for (String query : queries) {
            if (query.startsWith("add")) {
                String name = query.split(" ")[1];
                contactsApp.add(name);
            } else if (query.startsWith("find")) {
                String partial = query.split(" ")[1];
                results.add(contactsApp.find(partial));
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of operations: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<String> queries = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            System.out.print("Enter operation: ");
            queries.add(scanner.nextLine());
        }

        List<Integer> results = contacts(queries);
        for (int result : results) {
            System.out.println(result);
        }
    }
}
