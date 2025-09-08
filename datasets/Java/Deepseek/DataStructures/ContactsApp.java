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
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            node.count++;
        }
    }

    public int find(String partial) {
        TrieNode node = root;
        for (int i = 0; i < partial.length(); i++) {
            char c = partial.charAt(i);
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
        Contacts contactList = new Contacts();
        List<Integer> results = new ArrayList<>();
        for (String query : queries) {
            String[] parts = query.split(" ");
            if (parts[0].equals("add")) {
                contactList.add(parts[1]);
            } else if (parts[0].equals("find")) {
                results.add(contactList.find(parts[1]));
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> queries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queries.add(scanner.nextLine());
        }
        List<Integer> output = contacts(queries);
        for (int result : output) {
            System.out.println(result);
        }
    }
}