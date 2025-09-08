import java.util.*;

class BitNode {
    Map<Integer, BitNode> children;
    
    public BitNode() {
        children = new HashMap<>();
    }
}

public class MaxSiValue {
    public static int maxXorTwoNumbers(int[] arr) {
        int maxXor = 0;
        BitNode root = new BitNode();
        
        for (int num : arr) {
            BitNode node = root;
            BitNode xorNode = root;
            int currentXor = 0;
            
            for (int i = 31; i >= 0; --i) {
                int bit = (num >> i) & 1;
                // Insert the number into the trie
                if (!node.children.containsKey(bit)) {
                    node.children.put(bit, new BitNode());
                }
                node = node.children.get(bit);
                
                // Compute currentXor by choosing the opposite bit if available
                int toggledBit = 1 - bit;
                if (xorNode.children.containsKey(toggledBit)) {
                    currentXor += (1 << i);
                    xorNode = xorNode.children.get(toggledBit);
                } else {
                    xorNode = xorNode.children.get(bit);
                }
            }
            
            if (currentXor > maxXor) {
                maxXor = currentXor;
            }
        }
        
        return maxXor;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        System.out.print("Enter the elements separated by space: ");
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.println("Maximum XOR: " + maxXorTwoNumbers(arr));
    }
}