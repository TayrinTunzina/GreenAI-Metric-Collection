import java.util.Scanner;

public class PetrolPumpTour {
    public static int findStartingPump(int[][] pumps) {
        int n = pumps.length;
        int totalPetrol = 0;
        int currentPetrol = 0;
        int startIndex = 0;

        for (int i = 0; i < n; i++) {
            totalPetrol += pumps[i][0] - pumps[i][1];
            currentPetrol += pumps[i][0] - pumps[i][1];

            if (currentPetrol < 0) {
                startIndex = i + 1;
                currentPetrol = 0;
            }
        }

        return (totalPetrol >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of petrol pumps: ");
        int n = scanner.nextInt();
        int[][] pumps = new int[n][2];

        for (int i = 0; i < n; i++) {
            pumps[i][0] = scanner.nextInt();
            pumps[i][1] = scanner.nextInt();
        }

        int result = findStartingPump(pumps);
        System.out.println("The smallest index from which we can start the tour is: " + result);
    }
}
