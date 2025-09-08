import java.util.Scanner;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class  LinkedListTraversal {

    public static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();

        SinglyLinkedListNode head = null;
        SinglyLinkedListNode prev = null;

        for (int i = 0; i < n; i++) {
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
        printLinkedList(head);

        scanner.close();
    }
}