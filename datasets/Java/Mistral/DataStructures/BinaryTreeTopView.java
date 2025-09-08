import java.util.*;

public class BinaryTreeTopView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println();
            return;
        }

        int[] nodes = new int[n];
        Map<Integer, Integer> nodeToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes[i] = sc.nextInt();
            nodeToIndex.put(nodes[i], i);
        }
        int rootVal = nodes[0];

        Map<Integer, List<Pair<Integer, Character>>> adj = new HashMap<>();
        int e = sc.nextInt();
        while (e-- > 0) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            char lr = sc.next().charAt(0);
            adj.computeIfAbsent(parent, k -> new ArrayList<>()).add(new Pair<>(child, lr));
        }

        Map<Integer, Integer> hdMap = new TreeMap<>();
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();  // {node, HD}
        q.add(new Pair<>(rootVal, 0));

        while (!q.isEmpty()) {
            Pair<Integer, Integer> current = q.poll();
            int node = current.getKey();
            int hd = current.getValue();

            if (!hdMap.containsKey(hd)) {
                hdMap.put(hd, node);
            }

            if (adj.containsKey(node)) {
                for (Pair<Integer, Character> entry : adj.get(node)) {
                    int child = entry.getKey();
                    char dir = entry.getValue();
                    if (dir == 'L') {
                        q.add(new Pair<>(child, hd - 1));
                    } else {
                        q.add(new Pair<>(child, hd + 1));
                    }
                }
            }
        }

        for (int val : hdMap.values()) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    static class Pair<K, V> {
        private K key;
        private V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() { return key; }
        public V getValue() { return value; }
    }
}