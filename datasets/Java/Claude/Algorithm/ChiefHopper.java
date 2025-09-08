import java.util.*;

public class ChiefHopper {
    
    public static int chiefHopper(int[] arr) {
        // Work backwards from the last building
        // We need at least 1 energy after completing all buildings
        int minEnergyNeeded = 1;
        
        // Go through buildings in reverse order
        for (int i = arr.length - 1; i >= 0; i--) {
            int height = arr[i];
            // To have minEnergyNeeded after jumping, we need:
            // 2 * before_energy - height >= minEnergyNeeded
            // before_energy >= (minEnergyNeeded + height) / 2
            minEnergyNeeded = (minEnergyNeeded + height + 1) / 2; // Ceiling division
        }
        
        return minEnergyNeeded;
    }
    
    public static void testExample() {
        int[] arr = {2, 3, 4, 3, 2};
        int result = chiefHopper(arr);
        
        System.out.print("Example: arr = [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Minimum starting energy: " + result);
        
        // Verify the solution
        int energy = result;
        System.out.println("\nVerification:");
        System.out.println("Starting energy: " + energy);
        
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int newEnergy = 2 * energy - height;
            System.out.println("Building " + i + ": height=" + height + 
                             ", energy: " + energy + " -> " + newEnergy);
            energy = newEnergy;
            if (energy < 0) {
                System.out.println("Energy went below 0! Solution is incorrect.");
                break;
            }
        }
        System.out.println("Final energy: " + energy);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Run test first
        testExample();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Main program
        System.out.print("Enter the number of buildings: ");
        int n = scanner.nextInt();
        
        int[] heights = new int[n];
        System.out.print("Enter the heights of buildings (space-separated): ");
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        
        int result = chiefHopper(heights);
        System.out.println("Minimum starting energy required: " + result);
        
        scanner.close();
    }
}