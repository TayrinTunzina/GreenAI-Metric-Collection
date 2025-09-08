import java.util.Scanner;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    SinglyLinkedListNode head;

    public void insertNode(int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (head == null) {
            head = newNode;
        } else {
            SinglyLinkedListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
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

        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            list.insertNode(data);
        }

        System.out.println("Linked list elements are:");
        printLinkedList(list.head);

        scanner.close();
    }
}
