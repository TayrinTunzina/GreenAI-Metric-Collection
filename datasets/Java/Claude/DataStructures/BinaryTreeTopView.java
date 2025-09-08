import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class QueueNode {
    TreeNode node;
    int hd; // horizontal distance
    
    QueueNode(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class BinaryTreeTopView {
    
    public static TreeNode buildTree(List<Integer> nodes, List<String[]> edges) {
        if (nodes.isEmpty()) return null;
        
        // Create node objects
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        for (int val : nodes) {
            nodeMap.put(val, new TreeNode(val));
        }
        
        // Find root (node that doesn't appear as a child)
        Set<Integer> children = new HashSet<>();
        Set<Integer> parents = new HashSet<>();
        
        for (String[] edge : edges) {
            int parent = Integer.parseInt(edge[0]);
            int child = Integer.parseInt(edge[1]);
            String direction = edge[2];
            
            parents.add(parent);
            children.add(child);
            
            if (direction.equals("L")) {
                nodeMap.get(parent).left = nodeMap.get(child);
            } else { // direction.equals("R")
                nodeMap.get(parent).right = nodeMap.get(child);
            }
        }
        
        // Root is in parents but not in children
        Integer rootVal = null;
        for (int parent : parents) {
            if (!children.contains(parent)) {
                rootVal = parent;
                break;
            }
        }
        
        // If no edges, first node is root
        if (rootVal == null && !nodes.isEmpty()) {
            rootVal = nodes.get(0);
        }
        
        return nodeMap.get(rootVal);
    }
    
    public static List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        // Map to store the first node at each horizontal distance
        Map<Integer, Integer> topViewMap = new HashMap<>();
        
        // Queue for level order traversal
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 0));
        
        while (!queue.isEmpty()) {
            QueueNode current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;
            
            // If this horizontal distance is seen for the first time,
            // this node is part of top view
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.val);
            }
            
            // Add left child with hd-1
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, hd - 1));
            }
            
            // Add right child with hd+1
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, hd + 1));
            }
        }
        
        // Sort by horizontal distance and extract values
        List<Integer> sortedKeys = new ArrayList<>(topViewMap.keySet());
        Collections.sort(sortedKeys);
        
        for (int hd : sortedKeys) {
            result.add(topViewMap.get(hd));
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of nodes
        int n = scanner.nextInt();
        
        if (n == 0) {
            System.out.println();
            return;
        }
        
        // Read node values
        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(scanner.nextInt());
        }
        
        // Read number of edges
        int e = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        // Read edges
        List<String[]> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            edges.add(parts);
        }
        
        // Build tree
        TreeNode root = buildTree(nodes, edges);
        
        // Get top view
        List<Integer> result = topView(root);
        
        // Print result
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result.get(i));
        }
        System.out.println();
        
        scanner.close();
    }
}