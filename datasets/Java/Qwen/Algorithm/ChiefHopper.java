import java.util.Scanner;
import java.lang.Math;

public class ChiefHopper {
    public static int chiefHopper(int[] arr) {
        double required = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            required = Math.ceil((required + arr[i]) / 2.0);
        }
        return (int) required;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(chiefHopper(arr));
        scanner.close();
    }
}