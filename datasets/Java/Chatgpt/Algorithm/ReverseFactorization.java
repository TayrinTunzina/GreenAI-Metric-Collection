import java.util.*;

public class ReverseFactorization {
    static class State {
        long val;
        List<Long> path;
        State(long val, List<Long> path) {
            this.val = val;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N and K: ");
        long N = sc.nextLong();
        int K = sc.nextInt();

        System.out.print("Enter " + K + " elements of A: ");
        int[] A = new int[K];
        for (int i = 0; i < K; i++) A[i] = sc.nextInt();
        Arrays.sort(A);

        Queue<State> queue = new LinkedList<>();
        Set<Long> visited = new HashSet<>();
        queue.offer(new State(1L, new ArrayList<>(List.of(1L))));
        visited.add(1L);

        while (!queue.isEmpty()) {
            State curr = queue.poll();
            if (curr.val == N) {
                for (long v : curr.path) System.out.print(v + " ");
                System.out.println();
                return;
            }
            for (int a : A) {
                long next = curr.val * a;
                if (next <= N && N % next == 0 && !visited.contains(next)) {
                    visited.add(next);
                    List<Long> newPath = new ArrayList<>(curr.path);
                    newPath.add(next);
                    queue.offer(new State(next, newPath));
                }
            }
        }

        System.out.println(-1);
    }
}
