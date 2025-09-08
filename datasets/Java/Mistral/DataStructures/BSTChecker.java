import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BSTChecker {
    public static boolean isBST(Node node, int minVal, int maxVal) {
        if (node == null) {
            return true;
        }
        if (node.data <= minVal || node.data >= maxVal) {
            return false;
        }
        return isBST(node.left, minVal, node.data) && isBST(node.right, node.data, maxVal);
    }

    public static Node insertLevelOrder(int[] arr, int i) {
        if (i < arr.length && arr[i] != -1) {
            Node root = new Node(arr[i]);
            root.left = insertLevelOrder(arr, 2 * i + 1);
            root.right = insertLevelOrder(arr, 2 * i + 2);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the tree nodes in level order (use -1 for None):");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Node root = insertLevelOrder(arr, 0);
        System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? "Yes" : "No");
    }
}
