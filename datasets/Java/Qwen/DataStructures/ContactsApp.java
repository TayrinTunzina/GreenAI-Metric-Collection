import java.io.*;
import java.util.*;

public class ContactsApp {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    public static List<Integer> contacts(List<String> queries) {
        TrieNode root = new TrieNode();
        List<Integer> result = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ", 2);
            String op = parts[0];
            String s = parts[1];

            TrieNode node = root;

            if (op.equals("add")) {
                for (char c : s.toCharArray()) {
                    node.children.putIfAbsent(c, new TrieNode());
                    node = node.children.get(c);
                    node.count++;
                }
            } else if (op.equals("find")) {
                boolean found = true;
                for (char c : s.toCharArray()) {
                    if (!node.children.containsKey(c)) {
                        found = false;
                        break;
                    }
                    node = node.children.get(c);
                }
                result.add(found ? node.count : 0);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> queries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            queries.add(br.readLine().trim());
        }

        List<Integer> results = contacts(queries);
        for (int res : results) {
            System.out.println(res);
        }
    }
}