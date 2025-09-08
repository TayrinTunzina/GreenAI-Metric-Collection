import java.util.Scanner;

class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class BSTChecker {
    static Scanner sc = new Scanner(System.in);

    static Node insertManual(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine();
        if (input.isEmpty()) return null;
        int val = Integer.parseInt(input);
        Node node = new Node(val);
        node.left = insertManual("Left of " + val + ": ");
        node.right = insertManual("Right of " + val + ": ");
        return node;
    }

    static boolean isBST(Node node, int minVal, int maxVal) {
        if (node == null) return true;
        if (node.data <= minVal || node.data >= maxVal) return false;
        return isBST(node.left, minVal, node.data) && isBST(node.right, node.data, maxVal);
    }

    public static void main(String[] args) {
        System.out.println("Press Enter for null value.");
        Node root = insertManual("Root: ");
        System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? "Yes" : "No");
    }
}
