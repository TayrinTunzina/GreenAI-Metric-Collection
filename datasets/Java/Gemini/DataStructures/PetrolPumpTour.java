import java.util.Scanner;

public class PetrolPumpTour {

    public static int canCompleteCircuit(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0;
        int tank = 0;
        int total_deficit = 0;

        for (int i = 0; i < n; i++) {
            tank += petrol[i] - distance[i];
            if (tank < 0) {
                start = i + 1;
                total_deficit += tank;
                tank = 0;
            }
        }

        return (tank + total_deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] petrol = new int[n];
        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            petrol[i] = scanner.nextInt();
            distance[i] = scanner.nextInt();
        }

        System.out.println(canCompleteCircuit(petrol, distance));
    }
}
