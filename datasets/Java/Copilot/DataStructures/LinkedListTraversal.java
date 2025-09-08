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

    public static SinglyLinkedListNode createLinkedList(int n, Scanner scanner) {
        if (n == 0) {
            return null;
        }
        SinglyLinkedListNode head = new SinglyLinkedListNode(scanner.nextInt());
        SinglyLinkedListNode current = head;
        for (int i = 1; i < n; i++) {
            SinglyLinkedListNode new_node = new SinglyLinkedListNode(scanner.nextInt());
            current.next = new_node;
            current = new_node;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of nodes in the linked list: ");
        int n = scanner.nextInt();
        SinglyLinkedListNode head = createLinkedList(n, scanner);
        printLinkedList(head);
        scanner.close();
    }
}
