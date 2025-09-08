import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0;
}

class Contacts {
    TrieNode root = new TrieNode();

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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Contacts contacts = new Contacts();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String op = parts[0];
            String arg = parts[1];

            if (op.equals("add")) {
                contacts.add(arg);
            } else if (op.equals("find")) {
                result.add(contacts.find(arg));
            }
        }

        for (int val : result) {
            System.out.println(val);
        }
    }
}
