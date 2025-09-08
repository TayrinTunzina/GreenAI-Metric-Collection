import java.util.Scanner;

public class PetrolPumpTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter the number of petrol pumps
        System.out.println("Enter the number of petrol pumps (N):");
        int n = scanner.nextInt();
        
        // Arrays to store petrol available and distance to next pump
        int[] petrol = new int[n];
        int[] distance = new int[n];
        
        // Prompt the user to input petrol and distance values for each pump
        System.out.println("For each petrol pump, enter the amount of petrol and distance to the next pump:");
        for (int i = 0; i < n; i++) {
            System.out.println("Petrol pump " + i + ":");
            System.out.print("Petrol amount: ");
            petrol[i] = scanner.nextInt();
            System.out.print("Distance to next pump: ");
            distance[i] = scanner.nextInt();
        }
        
        // Find the starting point using greedy approach
        int start = 0;          // Starting point index
        int currentFuel = 0;    // Current fuel in tank
        int deficit = 0;        // Total deficit encountered
        
        for (int i = 0; i < n; i++) {
            // Update current fuel after visiting current pump and traveling to next
            currentFuel += petrol[i] - distance[i];
            
            // If we can't reach the next pump
            if (currentFuel < 0) {
                // Keep track of the deficit
                deficit += currentFuel;
                // Try starting from the next pump
                start = i + 1;
                // Reset current fuel
                currentFuel = 0;
            }
        }
        
        // Check if we can complete the circuit
        if (currentFuel + deficit >= 0) {
            System.out.println("The smallest index from which the truck can complete the circle: " + start);
        } else {
            System.out.println("-1"); // No solution exists
        }
        
        scanner.close();
    }
}