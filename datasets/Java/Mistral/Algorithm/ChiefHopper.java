import java.util.Scanner;

public class ChiefHopper {
    public static int chiefHopper(int[] arr) {
        int n = arr.length;
        int minEnergy = 0;

        for (int i = n - 1; i >= 0; i--) {
            int currentEnergy = (minEnergy + arr[i] + 1) / 2;
            minEnergy = currentEnergy;
        }

        return minEnergy;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of buildings: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter the heights of the buildings: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Minimum starting energy: " + chiefHopper(arr));

        scanner.close();
    }
}
