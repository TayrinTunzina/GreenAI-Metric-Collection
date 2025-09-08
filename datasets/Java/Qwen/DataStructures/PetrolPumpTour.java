import java.util.Scanner;

public class PetrolPumpTour {
    public static int findStartingPoint(int n, int[][] petrolPumps) {
        int start = 0;
        long totalPetrol = 0, totalDistance = 0;
        long currentPetrol = 0;
        for (int i = 0; i < n; i++) {
            int petrol = petrolPumps[i][0];
            int distance = petrolPumps[i][1];
            totalPetrol += petrol;
            totalDistance += distance;
            currentPetrol += petrol - distance;
            if (currentPetrol < 0) {
                start = i + 1;
                currentPetrol = 0;
            }
        }
        if (totalPetrol >= totalDistance) {
            return start % n;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of petrol pumps: ");
        int n = scanner.nextInt();
        int[][] petrolPumps = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter petrol and distance (space-separated): ");
            petrolPumps[i][0] = scanner.nextInt(); // Petrol
            petrolPumps[i][1] = scanner.nextInt(); // Distance
        }
        int result = findStartingPoint(n, petrolPumps);
        System.out.println("The starting point is: " + result);
        scanner.close();
    }
}