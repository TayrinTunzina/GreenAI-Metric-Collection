import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class BSTChecker {
    
    public static boolean checkBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean validate(TreeNode node, long minVal, long maxVal) {
        if (node == null) return true;
        
        if (node.data <= minVal || node.data >= maxVal) {
            return false;
        }
        
        return validate(node.left, minVal, node.data) && 
               validate(node.right, node.data, maxVal);
    }
    
    public static TreeNode buildTree() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the tree nodes level by level (use -1 for null nodes):");
        System.out.println("Example: 3 5 2 1 4 6 -1 -1 -1 -1 -1 -1 -1");
        
        String[] input = scanner.nextLine().split(" ");
        List<Integer> values = new ArrayList<>();
        
        for (String s : input) {
            values.add(Integer.parseInt(s));
        }
        
        if (values.isEmpty() || values.get(0) == -1) {
            return null;
        }
        
        TreeNode root = new TreeNode(values.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < values.size()) {
            TreeNode node = queue.poll();
            
            // Left child
            if (i < values.size() && values.get(i) != -1) {
                node.left = new TreeNode(values.get(i));
                queue.offer(node.left);
            }
            i++;
            
            // Right child
            if (i < values.size() && values.get(i) != -1) {
                node.right = new TreeNode(values.get(i));
                queue.offer(node.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static void printTree(TreeNode root, int level, String prefix) {
        if (root != null) {
            System.out.println(" ".repeat(level * 4) + prefix + root.data);
            if (root.left != null || root.right != null) {
                printTree(root.left, level + 1, "L--- ");
                printTree(root.right, level + 1, "R--- ");
            }
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = buildTree();
        
        if (root != null) {
            System.out.println("\nBuilt tree:");
            printTree(root, 0, "Root: ");
            
            boolean result = checkBST(root);
            System.out.println("\nIs BST: " + (result ? "Yes" : "No"));
        } else {
            System.out.println("Empty tree - considered valid BST: Yes");
        }
    }
}