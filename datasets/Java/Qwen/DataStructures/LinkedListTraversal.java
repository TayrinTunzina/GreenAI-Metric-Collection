import java.util.Scanner;

// Definition of a singly linked list node
class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListTraversal {

    // Function to print the linked list
    public static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);  // Print the data of the current node
            current = current.next;           // Move to the next node
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();

        SinglyLinkedListNode head = null;

        if (n > 0) {
            // Create the head node
            System.out.print("Enter the data for the first node: ");
            int headData = scanner.nextInt();
            head = new SinglyLinkedListNode(headData);
            SinglyLinkedListNode current = head;

            // Add remaining nodes
            for (int i = 1; i < n; i++) {
                System.out.print("Enter the data for the next node: ");
                int data = scanner.nextInt();
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
                current.next = newNode;
                current = newNode;
            }
        }

        // Call the function to print the linked list
        printLinkedList(head);

        scanner.close();
    }
}