import java.util.Scanner;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int value) {
        this.data = value;
        this.next = null;
    }
}

public class LinkedListTraversal {
    public static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of nodes
        System.out.print("Enter the number of nodes: ");
        int numberOfNodes = scanner.nextInt();

        // Create the head node
        System.out.print("Enter the value for node 1: ");
        SinglyLinkedListNode head = new SinglyLinkedListNode(scanner.nextInt());
        SinglyLinkedListNode current = head;

        // Create the rest of the nodes
        for (int i = 2; i <= numberOfNodes; i++) {
            System.out.print("Enter the value for node " + i + ": ");
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(scanner.nextInt());
            current.next = newNode;
            current = newNode;
        }

        // Print the linked list
        printLinkedList(head);

        scanner.close();
    }
}
