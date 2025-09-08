import java.util.*;

class Node {
    int value;
    Node left, right;
    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

public class BinaryTreeTopView {
    public static void printTopView(Node root) {
        if (root == null) return;
        
        class QueueObj {
            Node node;
            int hd;
            QueueObj(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        
        Queue<QueueObj> queue = new LinkedList<>();
        Map<Integer, Integer> topView = new TreeMap<>();
        
        queue.add(new QueueObj(root, 0));
        
        while (!queue.isEmpty()) {
            QueueObj current = queue.poll();
            int hd = current.hd;
            Node node = current.node;
            
            if (!topView.containsKey(hd)) {
                topView.put(hd, node.value);
            }
            
            if (node.left != null) {
                queue.add(new QueueObj(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new QueueObj(node.right, hd + 1));
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : topView.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) return;
        
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        
        int e = scanner.nextInt();
        Map<Integer, Node> nodes = new HashMap<>();
        for (int val : values) {
            nodes.put(val, new Node(val));
        }
        
        Node root = nodes.get(values[0]);
        
        for (int i = 0; i < e; i++) {
            int parentVal = scanner.nextInt();
            int childVal = scanner.nextInt();
            String direction = scanner.next();
            Node parent = nodes.get(parentVal);
            Node child = nodes.get(childVal);
            if (direction.equals("L")) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        
        printTopView(root);
    }
}
