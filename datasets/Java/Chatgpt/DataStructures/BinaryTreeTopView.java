import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int d) { data = d; }
}

class Pair {
    Node node; int hd;
    Pair(Node n, int h) { node = n; hd = h; }
}

public class BinaryTreeTopView {
    public static void topView(Node root) {
        if (root == null) return;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (!map.containsKey(p.hd))
                map.put(p.hd, p.node.data);
            if (p.node.left != null)
                q.add(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null)
                q.add(new Pair(p.node.right, p.hd + 1));
        }
        for (int val : map.values())
            System.out.print(val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();
        if (n == 0) return;
        Map<Integer, Node> nodes = new HashMap<>();
        System.out.println("Enter node values (unique IDs):");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            nodes.put(val, new Node(val));
        }
        System.out.println("Enter number of edges:");
        int e = sc.nextInt();
        if (e > n - 1) {
            System.out.println("Error: too many edges");
            return;
        }
        System.out.println("Enter edges in format: parent child L/R");
        for (int i = 0; i < e; i++) {
            int p = sc.nextInt(), c = sc.nextInt();
            String d = sc.next();
            if (!nodes.containsKey(p) || !nodes.containsKey(c)) {
                System.out.println("Error: invalid node ID");
                return;
            }
            if (d.equalsIgnoreCase("L")) nodes.get(p).left = nodes.get(c);
            else if (d.equalsIgnoreCase("R")) nodes.get(p).right = nodes.get(c);
            else {
                System.out.println("Error: direction must be L or R");
                return;
            }
        }
        topView(nodes.get(nodes.keySet().iterator().next()));
    }
}