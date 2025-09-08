import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Define the TrieNode class
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int count = 0; // Tracks how many words pass through this node
}

public class ContactsApp {

    public static List<Integer> contacts(List<List<String>> queries) {
        TrieNode root = new TrieNode();
        List<Integer> results = new ArrayList<>();

        for (List<String> query : queries) {
            String operation = query.get(0);
            String value = query.get(1);

            if (operation.equals("add")) {
                TrieNode current = root;
                for (char ch : value.toCharArray()) {
                    int index = ch - 'a';
                    if (current.children[index] == null) {
                        current.children[index] = new TrieNode();
                    }
                    current = current.children[index];
                    current.count++;
                }
            } else if (operation.equals("find")) {
                TrieNode current = root;
                boolean found = true;
                for (char ch : value.toCharArray()) {
                    int index = ch - 'a';
                    if (current.children[index] == null) {
                        results.add(0);
                        found = false;
                        break;
                    }
                    current = current.children[index];
                }
                if (found) {
                    results.add(current.count);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] queryParts = bufferedReader.readLine().split(" ");
            List<String> query = new ArrayList<>();
            query.add(queryParts[0]);
            query.add(queryParts[1]);
            queries.add(query);
        }

        List<Integer> results = contacts(queries);

        for (int res : results) {
            System.out.println(res);
        }

        bufferedReader.close();
    }
}