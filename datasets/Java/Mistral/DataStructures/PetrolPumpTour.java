import java.util.Scanner;

public class PetrolPumpTour {

    public static int canCompleteCircle(int[][] petrolPumps) {
        int n = petrolPumps.length;
        int totalPetrol = 0, totalDistance = 0, currentPetrol = 0, startIndex = 0;

        for (int i = 0; i < n; ++i) {
            int petrol = petrolPumps[i][0];
            int distance = petrolPumps[i][1];
            totalPetrol += petrol;
            totalDistance += distance;
            currentPetrol += petrol - distance;

            if (currentPetrol < 0) {
                startIndex = i + 1;
                currentPetrol = 0;
            }
        }

        return (totalPetrol >= totalDistance) ? startIndex : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of petrol pumps: ");
        int n = scanner.nextInt();
        int[][] petrolPumps = new int[n][2];

        for (int i = 0; i < n; ++i) {
            System.out.print("Enter petrol and distance: ");
            petrolPumps[i][0] = scanner.nextInt();
            petrolPumps[i][1] = scanner.nextInt();
        }

        int startIndex = canCompleteCircle(petrolPumps);
        System.out.println("Starting index: " + startIndex);
        scanner.close();
    }
}
