import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0;
}

public class ContactsApp {
    TrieNode root = new TrieNode();

    public void add(String name) {
        TrieNode node = root;
        for (char c : name.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
            node.count++;
        }
    }

    public int find(String partial) {
        TrieNode node = root;
        for (char c : partial.toCharArray()) {
            if (!node.children.containsKey(c)) return 0;
            node = node.children.get(c);
        }
        return node.count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactsApp app = new ContactsApp();
        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            if (parts[0].equals("add")) {
                app.add(parts[1]);
            } else if (parts[0].equals("find")) {
                results.add(app.find(parts[1]));
            }
        }

        System.out.println("Results:");
        for (int r : results) System.out.println(r);
    }
}
