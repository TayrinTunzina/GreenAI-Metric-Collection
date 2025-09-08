import java.util.*;

public class ChiefHopper {
    public static int chiefHopper(int[] arr) {
        long energy = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            energy = (energy + arr[i] + 1) / 2; // ceiling division
        }
        return (int) energy;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of buildings: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter building heights: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Minimum starting energy: " + chiefHopper(arr));
    }
}
