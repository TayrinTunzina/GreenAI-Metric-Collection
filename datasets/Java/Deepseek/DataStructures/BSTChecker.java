import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BSTChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the tree in level-order (use -1 for null nodes): ");
        
        String[] input = sc.nextLine().trim().split("\\s+");
        List<Integer> arr = new ArrayList<>();
        for (String s : input) {
            arr.add(Integer.parseInt(s));
        }
        
        Node root = buildTree(arr);
        System.out.println(isBST(root) ? "Yes" : "No");
    }

    static Node buildTree(List<Integer> arr) {
        if (arr.isEmpty() || arr.get(0) == -1) return null;
        Node root = new Node(arr.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int index = 1;
        while (!q.isEmpty() && index < arr.size()) {
            Node current = q.poll();
            if (index < arr.size() && arr.get(index) != -1) {
                current.left = new Node(arr.get(index));
                q.add(current.left);
            }
            index++;
            if (index < arr.size() && arr.get(index) != -1) {
                current.right = new Node(arr.get(index));
                q.add(current.right);
            }
            index++;
        }
        return root;
    }

    static boolean isBST(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node prev = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (prev != null && current.data <= prev.data) {
                return false;
            }
            prev = current;
            current = current.right;
        }
        return true;
    }
}