import java.util.Scanner;

public class ChiefHopper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(chiefHopper(arr));
    }

    public static int chiefHopper(int[] arr) {
        int left = 0;
        int maxHeight = 0;
        for (int num : arr) {
            if (num > maxHeight) {
                maxHeight = num;
            }
        }
        int right = maxHeight;
        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long currentEnergy = mid;
            boolean possible = true;
            for (int height : arr) {
                if (currentEnergy > height) {
                    currentEnergy += (currentEnergy - height);
                } else {
                    currentEnergy -= (height - currentEnergy);
                }
                if (currentEnergy < 0) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}