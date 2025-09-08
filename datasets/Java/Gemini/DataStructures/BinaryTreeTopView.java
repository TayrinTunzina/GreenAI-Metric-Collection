import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTreeTopView {
    public static void topView(Node root) {
        if (root == null) {
            return;
        }

        class QueueObj {
            Node node;
            int hd;

            QueueObj(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        Queue<QueueObj> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new QueueObj(root, 0));

        while (!q.isEmpty()) {
            QueueObj temp = q.poll();
            Node node = temp.node;
            int hd = temp.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            if (node.left != null) {
                q.add(new QueueObj(node.left, hd - 1));
            }
            if (node.right != null) {
                q.add(new QueueObj(node.right, hd + 1));
            }
        }

        for (int value : map.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static Node buildTree(int[] nodes, String[] edges) {
        if (nodes.length == 0) return null;
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int val : nodes) {
            nodeMap.put(val, new Node(val));
        }

        Node root = nodeMap.get(nodes[0]);

        for (String edge : edges) {
            String[] parts = edge.split(" ");
            int parentVal = Integer.parseInt(parts[0]);
            int childVal = Integer.parseInt(parts[1]);
            char dir = parts[2].charAt(0);

            Node parent = nodeMap.get(parentVal);
            Node child = nodeMap.get(childVal);

            if (dir == 'L') {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = scanner.nextInt();
        }

        int e = scanner.nextInt();
        scanner.nextLine();
        String[] edges = new String[e];
        for (int i = 0; i < e; i++) {
            edges[i] = scanner.nextLine();
        }
        scanner.close();

        Node root = buildTree(nodes, edges);
        topView(root);
    }
}