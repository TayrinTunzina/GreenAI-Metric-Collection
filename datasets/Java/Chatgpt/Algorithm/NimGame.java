import java.util.*;

public class NimGame {
    static final int MOD = 1_000_000_007;

    static int computeXOR(List<Integer> list) {
        int res = 0;
        for (int val : list)
            res ^= val;
        return res;
    }

    static int countNimGames(int n, int m) {
        int limit = 1 << m;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < limit; i++)
            nums.add(i);

        int total = 0;
        int size = nums.size();

        // Generate all combinations of n numbers
        int[] indices = new int[n];
        total = combine(nums, new ArrayList<>(), 0, n);
        return total % MOD;
    }

    static int combine(List<Integer> nums, List<Integer> temp, int start, int k) {
        if (k == 0) {
            return countPermutationsWithXOR(temp);
        }
        int total = 0;
        for (int i = start; i <= nums.size() - k; i++) {
            temp.add(nums.get(i));
            total = (total + combine(nums, temp, i + 1, k - 1)) % MOD;
            temp.remove(temp.size() - 1);
        }
        return total;
    }

    static int countPermutationsWithXOR(List<Integer> list) {
        List<Integer> temp = new ArrayList<>(list);
        Collections.sort(temp);
        int count = 0;
        do {
            if (computeXOR(temp) != 0)
                count++;
        } while (nextPermutation(temp));
        return count;
    }

    static boolean nextPermutation(List<Integer> nums) {
        int i = nums.size() - 2;
        while (i >= 0 && nums.get(i) >= nums.get(i + 1)) i--;
        if (i < 0) return false;

        int j = nums.size() - 1;
        while (nums.get(j) <= nums.get(i)) j--;

        Collections.swap(nums, i, j);
        Collections.reverse(nums.subList(i + 1, nums.size()));
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        System.out.println(countNimGames(n, m));
    }
}
