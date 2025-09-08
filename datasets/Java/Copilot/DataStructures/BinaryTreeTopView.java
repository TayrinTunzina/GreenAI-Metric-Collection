import java.util.*;

class Node {
    int val;
    Node left, right;
    Node(int v) { val = v; }
}

public class BinaryTreeTopView {
    static Node buildTree(int n, int[] values, int e, List<String[]> edges) {
        if (n == 0) return null;
        Map<Integer, Node> nodes = new HashMap<>();
        for (int val : values)
            nodes.put(val, new Node(val));
        for (String[] edge : edges) {
            if (edge.length != 3) continue;
            int p = Integer.parseInt(edge[0]);
            int c = Integer.parseInt(edge[1]);
            char lr = edge[2].charAt(0);
            if (!nodes.containsKey(p) || !nodes.containsKey(c)) continue;
            if (lr == 'L') nodes.get(p).left = nodes.get(c);
            else if (lr == 'R') nodes.get(p).right = nodes.get(c);
        }
        return nodes.get(values[0]);
    }

    static void topView(Node root) {
        if (root == null) return;
        Map<Integer, Integer> hdMap = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (!hdMap.containsKey(p.hd))
                hdMap.put(p.hd, p.node.val);
            if (p.node.left != null) q.add(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null) q.add(new Pair(p.node.right, p.hd + 1));
        }
        for (int val : hdMap.values())
            System.out.print(val + " ");
        System.out.println();
    }

    static class Pair {
        Node node;
        int hd;
        Pair(Node n, int h) { node = n; hd = h; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("No nodes in the tree.");
            return;
        }
        int[] values = new int[n];
        System.out.print("Enter node values: ");
        for (int i = 0; i < n; i++) values[i] = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();
        sc.nextLine();
        List<String[]> edges = new ArrayList<>();
        System.out.println("Enter edges (parent child L/R):");
        for (int i = 0; i < e; i++) {
            String[] parts = sc.nextLine().split(" ");
            if (parts.length == 3 && (parts[2].equals("L") || parts[2].equals("R")))
                edges.add(parts);
        }
        Node root = buildTree(n, values, e, edges);
        System.out.println("Top view of the tree:");
        topView(root);
    }
}