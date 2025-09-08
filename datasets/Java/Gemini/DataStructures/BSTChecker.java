import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BSTChecker {

    // Helper function for BST validation
    public static boolean isBSTHelper(Node node, long minVal, long maxVal) {
        // An empty tree is a valid BST
        if (node == null) {
            return true;
        }

        // Check if the current node's data is within the valid range
        // Use long for minVal/maxVal to handle Integer.MIN_VALUE/MAX_VALUE as node data
        if (node.data <= minVal || node.data >= maxVal) {
            return false;
        }

        // Recursively check left subtree: update maxVal to current node's data
        // Recursively check right subtree: update minVal to current node's data
        return isBSTHelper(node.left, minVal, node.data) &&
               isBSTHelper(node.right, node.data, maxVal);
    }

    // Main function to check if a binary tree is a BST
    public static boolean isBinarySearchTree(Node root) {
        // Initialize with Long.MIN_VALUE and Long.MAX_VALUE for the root's range
        return isBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Function to build a tree from level-order input
    public static Node buildTreeFromInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter tree nodes in level order (BFS), separated by spaces.");
        System.out.println("Use 'null' for missing children (e.g., 3 5 2 1 4 6 null):");
        String[] inputTokens = bufferedReader.readLine().trim().split(" ");

        if (inputTokens.length == 0 || inputTokens[0].equalsIgnoreCase("null")) {
            return null;
        }

        Node root = new Node(Integer.parseInt(inputTokens[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < inputTokens.length) {
            Node currentNode = queue.poll();

            // Left child
            if (i < inputTokens.length && !inputTokens[i].equalsIgnoreCase("null")) {
                int leftData = Integer.parseInt(inputTokens[i]);
                currentNode.left = new Node(leftData);
                queue.add(currentNode.left);
            }
            i++;

            // Right child
            if (i < inputTokens.length && !inputTokens[i].equalsIgnoreCase("null")) {
                int rightData = Integer.parseInt(inputTokens[i]);
                currentNode.right = new Node(rightData);
                queue.add(currentNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        Node root = buildTreeFromInput();

        if (isBinarySearchTree(root)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}