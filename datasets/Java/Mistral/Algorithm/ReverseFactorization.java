import java.util.*;

public class ReverseFactorization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N and K: ");
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] A = new int[K];
        System.out.print("Enter the elements of A: ");
        for (int i = 0; i < K; i++) {
            A[i] = scanner.nextInt();
        }

        List<Integer> result = reverseFactorization(N, A);
        if (result.size() == 1 && result.get(0) == -1) {
            System.out.println(-1);
        } else {
            System.out.print("1 ");
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static List<Integer> reverseFactorization(int N, int[] A) {
        Arrays.sort(A);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int currentValue = current.value;
            List<Integer> sequence = current.sequence;

            if (currentValue == N) {
                return sequence;
            }

            for (int a : A) {
                long nextValue = (long) currentValue * a;
                if (nextValue <= N) {
                    List<Integer> newSequence = new ArrayList<>(sequence);
                    newSequence.add((int) nextValue);
                    queue.add(new Pair((int) nextValue, newSequence));
                }
            }
        }

        return Collections.singletonList(-1);
    }

    static class Pair {
        int value;
        List<Integer> sequence;

        Pair(int value, List<Integer> sequence) {
            this.value = value;
            this.sequence = sequence;
        }
    }
}
