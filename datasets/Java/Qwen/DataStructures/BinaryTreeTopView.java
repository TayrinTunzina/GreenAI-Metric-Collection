import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeTopView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read n
        int n;
        try {
            n = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println();
            return;
        }

        if (n == 0) {
            System.out.println();
            return;
        }

        // Read node values
        String[] valStrs = sc.nextLine().split("\\s+");
        List<Integer> values = new ArrayList<>();
        Map<Integer, TreeNode> nodeMap = new HashMap<>();

        for (String s : valStrs) {
            if (!s.isEmpty()) {
                int val = Integer.parseInt(s);
                values.add(val);
                nodeMap.put(val, new TreeNode(val));
            }
        }

        // Read number of edges
        int e = 0;
        try {
            e = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception ex) {
            // If no edges, just print root
            System.out.println(values.get(0));
            return;
        }

        Set<Integer> children = new HashSet<>();

        // Read e edges
        for (int i = 0; i < e; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            if (parts.length < 3) continue;

            try {
                int parentVal = Integer.parseInt(parts[0]);
                int childVal = Integer.parseInt(parts[1]);
                String dir = parts[2];

                if (!nodeMap.containsKey(parentVal) || !nodeMap.containsKey(childVal)) {
                    continue;
                }

                TreeNode parent = nodeMap.get(parentVal);
                TreeNode child = nodeMap.get(childVal);

                if (dir.equals("L")) {
                    parent.left = child;
                } else if (dir.equals("R")) {
                    parent.right = child;
                }

                children.add(childVal);
            } catch (Exception ex) {
                continue;
            }
        }

        // Find root: node not in children
        TreeNode root = null;
        for (int val : values) {
            if (!children.contains(val)) {
                root = nodeMap.get(val);
                break;
            }
        }

        // Fallback
        if (root == null) {
            root = nodeMap.get(values.get(0));
        }

        // BFS for top view
        Map<Integer, Integer> hdMap = new TreeMap<>(); // hd -> node value
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0});

        while (!queue.isEmpty()) {
            Object[] item = queue.poll();
            TreeNode node = (TreeNode) item[0];
            int hd = (Integer) item[1];

            // Only record first node at this hd
            hdMap.putIfAbsent(hd, node.val);

            if (node.left != null) {
                queue.offer(new Object[]{node.left, hd - 1});
            }
            if (node.right != null) {
                queue.offer(new Object[]{node.right, hd + 1});
            }
        }

        // Output
        StringBuilder sb = new StringBuilder();
        for (int val : hdMap.values()) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}