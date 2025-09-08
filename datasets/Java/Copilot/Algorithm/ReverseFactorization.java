import java.util.*;

public class ReverseFactorization {
    static class Node {
        int val;
        List<Integer> path;
        Node(int val, List<Integer> path) {
            this.val = val;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N and K: ");
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.print("Enter " + K + " integers for A: ");
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < K; i++) A.add(sc.nextInt());
        Collections.sort(A);

        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new Node(1, new ArrayList<>(Arrays.asList(1))));
        visited.add(1);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (int a : A) {
                long next = (long) curr.val * a;
                if (next > N || N % next != 0 || visited.contains((int) next)) continue;
                visited.add((int) next);
                List<Integer> newPath = new ArrayList<>(curr.path);
                newPath.add((int) next);
                if (next == N) {
                    for (int num : newPath) System.out.print(num + " ");
                    System.out.println();
                    return;
                }
                queue.offer(new Node((int) next, newPath));
            }
        }
        System.out.println("-1");
    }
}
