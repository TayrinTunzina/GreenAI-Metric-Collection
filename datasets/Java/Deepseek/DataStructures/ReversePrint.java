import java.util.Scanner;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReversePrint {

    public static void reversePrint(SinglyLinkedListNode head) {
        if (head == null) {
            return;
        }
        // Recursively print the rest of the list
        reversePrint(head.next);
        // Print the current node's data
        System.out.println(head.data);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Enter the number of elements in the list: ");
            int n = scanner.nextInt();

            SinglyLinkedListNode head = null;
            SinglyLinkedListNode prev = null;

            for (int j = 0; j < n; j++) {
                System.out.print("Enter the data for the node: ");
                int data = scanner.nextInt();
                SinglyLinkedListNode node = new SinglyLinkedListNode(data);
                if (head == null) {
                    head = node;
                } else {
                    prev.next = node;
                }
                prev = node;
            }

            // Output
            reversePrint(head);
        }

        scanner.close();
    }
}