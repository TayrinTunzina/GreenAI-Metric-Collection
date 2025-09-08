import java.util.Scanner;

public class PetrolPumpTour {
    public static int findStartingPetrolPump(int N, int[][] petrolPumps) {
        int start = 0;
        int totalPetrol = 0;
        int currentPetrol = 0;
        
        for (int i = 0; i < N; i++) {
            int petrol = petrolPumps[i][0];
            int distance = petrolPumps[i][1];
            totalPetrol += petrol - distance;
            currentPetrol += petrol - distance;
            
            if (currentPetrol < 0) {
                start = i + 1;
                currentPetrol = 0;
            }
        }
        
        return (totalPetrol >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of petrol pumps: ");
        int N = scanner.nextInt();
        
        int[][] petrolPumps = new int[N][2];
        for (int i = 0; i < N; i++) {
            System.out.print("Enter the amount of petrol at pump " + i + ": ");
            petrolPumps[i][0] = scanner.nextInt();
            System.out.print("Enter the distance to the next pump from pump " + i + ": ");
            petrolPumps[i][1] = scanner.nextInt();
        }
        
        int result = findStartingPetrolPump(N, petrolPumps);
        System.out.println("The starting petrol pump index is: " + result);
        
        scanner.close();
    }
}