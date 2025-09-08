import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int val) {
        this.data = val;
        left = right = null;
    }
}

public class BSTChecker {

    public static boolean isBST(Node node, int minVal, int maxVal) {
        if (node == null) return true;
        if (node.data <= minVal || node.data >= maxVal)
            return false;
        return isBST(node.left, minVal, node.data) &&
               isBST(node.right, node.data, maxVal);
    }

    public static Node buildTree(List<Integer> arr) {
        if (arr.isEmpty() || arr.get(0) == -1) return null;
        Node root = new Node(arr.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < arr.size()) {
            Node curr = q.poll();

            if (i < arr.size() && arr.get(i) != -1) {
                curr.left = new Node(arr.get(i));
                q.add(curr.left);
            }
            i++;

            if (i < arr.size() && arr.get(i) != -1) {
                curr.right = new Node(arr.get(i));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes in level order (-1 for null):");

        // FIXED: Read entire line properly
        String line = sc.nextLine();
        String[] tokens = line.trim().split("\\s+");

        List<Integer> arr = new ArrayList<>();
        for (String token : tokens) {
            arr.add(Integer.parseInt(token));
        }

        Node root = buildTree(arr);
        System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? "Yes" : "No");
    }
}
