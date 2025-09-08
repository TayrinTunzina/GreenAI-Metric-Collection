import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;
    
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class BSTChecker {
    static Scanner scanner = new Scanner(System.in);
    
    public static boolean isBSTUtil(Node node, long minVal, long maxVal) {
        // An empty tree is BST
        if (node == null) {
            return true;
        }
        
        // False if this node violates the min/max constraint
        if (node.data < minVal || node.data > maxVal) {
            return false;
        }
        
        // Otherwise check the subtrees recursively
        // tightening the min or max constraint
        return (isBSTUtil(node.left, minVal, (long)node.data - 1) &&
                isBSTUtil(node.right, (long)node.data + 1, maxVal));
    }
    
    public static boolean isBST(Node root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public static Node insertNode() {
        System.out.print("Enter node value (or -1 to skip): ");
        int val = scanner.nextInt();
        
        if (val == -1) {
            return null;
        }
        
        Node node = new Node(val);
        System.out.println("Enter left child of " + val + ":");
        node.left = insertNode();
        System.out.println("Enter right child of " + val + ":");
        node.right = insertNode();
        
        return node;
    }
    
    public static void main(String[] args) {
        System.out.println("Enter the binary tree:");
        System.out.println("Enter -1 for null nodes");
        Node root = insertNode();
        
        if (isBST(root)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}