import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ChiefHopper {

    /*
     * Calculates the minimum starting energy by working backward from the last building.
     */
    public static int chiefHopper(List<Integer> arr) {
        long requiredEnergy = 0;
        
        // Iterate from the last building to the first
        for (int i = arr.size() - 1; i >= 0; i--) {
            int height = arr.get(i);
            
            // Using Math.ceil
            // requiredEnergy = (long) Math.ceil((double)(requiredEnergy + height) / 2.0);

            // Or using integer math for precision and efficiency
            requiredEnergy = (requiredEnergy + height + 1) / 2;
        }
        
        return (int) requiredEnergy;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the rest of the line
        
        List<Integer> arr = new ArrayList<>();
        String[] arrItems = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(arrItems[i]));
        }
        
        int result = chiefHopper(arr);
        System.out.println(result);
        
        scanner.close();
    }
}